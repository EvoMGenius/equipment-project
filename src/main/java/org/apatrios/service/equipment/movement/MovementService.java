package org.apatrios.service.equipment.movement;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.apatrios.model.equipment.Movement;
import org.apatrios.model.equipment.MovementStatus;
import org.apatrios.model.equipment.QMovement;
import org.apatrios.repository.equipment.MovementRepository;
import org.apatrios.service.equipment.movement.argument.CreateMovementArgument;
import org.apatrios.service.equipment.movement.argument.SearchMovementArgument;
import org.apatrios.service.equipment.movement.argument.UpdateMovementArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import org.apatrios.exception.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovementService {

    private final MovementRepository repository;
    private final QMovement qMovement = QMovement.movement;

    @Transactional
    public Movement create(@NonNull CreateMovementArgument argument) {
        return repository.save(Movement.builder()
                                       .startDate(LocalDateTime.now())
                                       .note(argument.getNote())
                                       .dateEnd(argument.getDateEnd())
                                       .pointFrom(argument.getPointFrom())
                                       .pointTo(argument.getPointTo())
                                       .status(MovementStatus.NEW)
                                       .createDate(LocalDateTime.now())
                                       .updateDate(LocalDateTime.now())
                                       .franchiseeIds(argument.getFranchiseeIds())
                                       .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Movement update(@NonNull UUID id, @NonNull UpdateMovementArgument argument) {
        Movement movement = getExisting(id);

        movement.setNote(argument.getNote());
        movement.setStatus(argument.getStatus());
        movement.setPointFrom(argument.getPointFrom());
        movement.setPointTo(argument.getPointTo());
        movement.setDateEnd(argument.getDateEnd());
        movement.setUpdateDate(LocalDateTime.now());
        movement.setFranchiseeIds(argument.getFranchiseeIds());

        return repository.save(movement);
    }

    @Transactional(readOnly = true)
    public Movement getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Movement.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Movement> list(@NonNull SearchMovementArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Movement> page(@NonNull SearchMovementArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchMovementArgument argument) {
        return QPredicates.builder()
                          .add(argument.getPointToId(), qMovement.pointTo.id::eq)
                          .add(argument.getPointFromId(), qMovement.pointFrom.id::eq)
                          .add(argument.getStatus(), qMovement.status::eq)
                          .add(argument.getNote(), qMovement.note::containsIgnoreCase)
                          .add(argument.getCreateDateFrom(), qMovement.createDate::goe)
                          .add(argument.getCreateDateTo(), qMovement.createDate::loe)
                          .add(argument.getStartDateFrom(), qMovement.startDate::goe)
                          .add(argument.getStartDateTo(), qMovement.startDate::loe)
                          .add(argument.getUpdateDateFrom(), qMovement.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qMovement.updateDate::loe)
                          .add(argument.isDeleted(), qMovement.isDeleted::eq)
                          .add(argument.getDateEndFrom(), qMovement.dateEnd::goe)
                          .add(argument.getDateEndTo(), qMovement.dateEnd::loe)
                          .add(argument.getFranchiseeIds(), qMovement.franchiseeIds.any()::in)
                          .addAnyString(argument.getSearchString(),
                                        qMovement.note::containsIgnoreCase,
                                        qMovement.status.stringValue()::containsIgnoreCase,
                                        qMovement.pointTo.name::containsIgnoreCase,
                                        qMovement.pointFrom.name::containsIgnoreCase)
                          .buildAnd();
    }
}
