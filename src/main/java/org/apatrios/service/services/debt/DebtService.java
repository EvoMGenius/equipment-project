package org.apatrios.service.services.debt;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.Debt;
import org.apatrios.model.services.DebtStatus;
import org.apatrios.model.services.QDebt;
import org.apatrios.repository.services.DebtRepository;
import org.apatrios.service.services.debt.argument.CreateDebtArgument;
import org.apatrios.service.services.debt.argument.SearchDebtArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DebtService {

    private final DebtRepository repository;
    private final QDebt qDebt = QDebt.debt;

    @Transactional
    public Debt create(@NonNull CreateDebtArgument argument) {
        return repository.save(Debt.builder()
                                   .debtType(argument.debtType())
                                   .status(DebtStatus.CREATED)
                                   .total(argument.total())
                                   .document(argument.document())
                                   .description(argument.description())
                                   .build());
    }

    @Transactional(readOnly = true)
    public Debt getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Debt.notFound"));
    }

    @Transactional(readOnly = true)
    public List<Debt> getAllByIds(@NonNull List<UUID> ids) {
        return repository.findAllById(ids);
    }

    @Transactional(readOnly = true)
    public Page<Debt> page(@NonNull SearchDebtArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchDebtArgument argument) {
        return QPredicates.builder()
                          .add(argument.description(), qDebt.description::containsIgnoreCase)
                          .add(argument.total(), qDebt.total::eq)
                          .add(argument.debtType(), qDebt.debtType::containsIgnoreCase)
                          .add(argument.status(), qDebt.status::eq)
                          .add(argument.documentId(), qDebt.document.id::eq)
                          .addAnyString(argument.searchString(), qDebt.description::containsIgnoreCase)
                          .buildAnd();
    }
}
