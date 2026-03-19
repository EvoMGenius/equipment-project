package org.apatrios.service.services.support;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.QSupport;
import org.apatrios.model.services.Support;
import org.apatrios.model.services.SupportStatus;
import org.apatrios.repository.services.SupportRepository;
import org.apatrios.service.services.support.argument.CreateSupportArgument;
import org.apatrios.service.services.support.argument.SearchSupportArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SupportService {

    private final SupportRepository repository;
    private final QSupport qSupport = QSupport.support;

    @Transactional
    public Support create(@NonNull CreateSupportArgument argument) {
        return repository.save(Support.builder()
                                      .type(argument.type())
                                      .description(argument.description())
                                      .photo(argument.photo())
                                      .childRepairId(argument.childRepairId())
                                      .status(SupportStatus.CREATED)
                                      .build());
    }

    @Transactional(readOnly = true)
    public Support getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Support.notFound"));
    }

    @Transactional(readOnly = true)
    public Page<Support> page(@NonNull SearchSupportArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchSupportArgument argument) {
        return QPredicates.builder()
                          .add(argument.type(), qSupport.type::containsIgnoreCase)
                          .add(argument.status(), qSupport.status::eq)
                          .add(argument.description(), qSupport.description::containsIgnoreCase)
                          .add(argument.childRepairId(), qSupport.childRepairId.id::eq)
                          .add(argument.createDateFrom(), qSupport.createDate::goe)
                          .add(argument.createDateTo(), qSupport.createDate::loe)
                          .buildAnd();
    }
}
