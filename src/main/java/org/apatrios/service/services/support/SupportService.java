package org.apatrios.service.services.support;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.QSupport;
import org.apatrios.model.services.Support;
import org.apatrios.repository.services.SupportRepository;
import org.apatrios.service.services.support.argument.CreateSupportArgument;
import org.apatrios.service.services.support.argument.SearchSupportArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SupportService {

    private final SupportRepository repository;
    private final QSupport qSupport = QSupport.support;

    @Transactional
    public Support create(@NonNull CreateSupportArgument argument) {
        return repository.save(Support.builder()
                                      .createDate(LocalDateTime.now())
                                      .type(argument.getType())
                                      .description(argument.getDescription())
                                      .photo(argument.getPhoto())
                                      .childRepairId(argument.getChildRepairId())
                                      .status(argument.getStatus())
                                      .build());
    }

    @Transactional(readOnly = true)
    public Support getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Support.notFound"));
    }

    @Transactional(readOnly = true)
    public List<Support> list(@NonNull SearchSupportArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    private Predicate buildPredicate(SearchSupportArgument argument) {
        return QPredicates.builder()
                          .add(argument.getTypeId(), qSupport.type.id::eq)
                          .add(argument.getStatusId(), qSupport.status.id::eq)
                          .add(argument.getDescription(), qSupport.description::containsIgnoreCase)
                          .add(argument.getChildRepairId(), qSupport.childRepairId.id::eq)
                          .add(argument.getCreateDateFrom(), qSupport.createDate::goe)
                          .add(argument.getCreateDateTo(), qSupport.createDate::loe)
                          .add(argument.getPhotoIds(), qSupport.photo.any().id::in)
                          .buildAnd();
    }
}
