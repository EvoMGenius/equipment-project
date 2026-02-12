package org.apatrios.service.equipment.status;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.equipment.QStatus;
import org.apatrios.model.equipment.Status;
import org.apatrios.repository.equipment.StatusRepository;
import org.apatrios.service.equipment.status.argument.CreateStatusArgument;
import org.apatrios.service.equipment.status.argument.SearchStatusArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StatusService {

    private final StatusRepository repository;
    private final QStatus qStatus = QStatus.status;

    @Transactional
    public Status create(@NonNull CreateStatusArgument argument) {
        return repository.save(Status.builder()
                                     .code(argument.getCode())
                                     .build());
    }

    @Transactional(readOnly = true)
    public List<Status> list(@NonNull SearchStatusArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    private Predicate buildPredicate(SearchStatusArgument argument) {
        return QPredicates.builder()
                          .add(argument.getCode(), qStatus.code::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Status getByCode(@NonNull String code) {
        return repository.findByCode(code)
                         .orElseThrow(() -> new EntityNotFoundException("Status.notFound"));
    }

    @Transactional(readOnly = true)
    public Status getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Status.notFound"));
    }
}
