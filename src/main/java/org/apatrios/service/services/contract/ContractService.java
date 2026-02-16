package org.apatrios.service.services.contract;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.ContactStatus;
import org.apatrios.model.services.Contract;
import org.apatrios.model.services.QContract;
import org.apatrios.repository.services.ContractRepository;
import org.apatrios.service.services.contract.argument.CreateContractArgument;
import org.apatrios.service.services.contract.argument.SearchContractArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository repository;
    private final QContract qContract = QContract.contract;

    @Transactional
    public Contract create(@NonNull CreateContractArgument argument) {
        return repository.save(Contract.builder()
                                       .doc(argument.getDoc())
                                       .status(ContactStatus.CREATED)
                                       .recruit(argument.getRecruit())
                                       .build());
    }

    @Transactional(readOnly = true)
    public Contract getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Contract.notFound"));
    }

    @Transactional(readOnly = true)
    public Page<Contract> page(@NonNull SearchContractArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchContractArgument argument) {
        return QPredicates.builder()
                          .add(argument.getDocId(), qContract.doc.id::eq)
                          .add(argument.getRecruitId(), qContract.recruit.id::eq)
                          .add(argument.getStatus(), qContract.status::eq)
                          .buildAnd();
    }
}
