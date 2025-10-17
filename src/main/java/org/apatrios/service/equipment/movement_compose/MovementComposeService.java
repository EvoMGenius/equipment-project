package org.apatrios.service.equipment.movement_compose;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.model.equipment.MovementCompose;
import org.apatrios.model.equipment.QMovementCompose;
import org.apatrios.repository.equipment.MovementComposeRepository;
import org.apatrios.service.equipment.movement_compose.argument.CreateMovementComposeArgument;
import org.apatrios.service.equipment.movement_compose.argument.SearchMovementComposeArgument;
import org.apatrios.service.equipment.movement_compose.argument.UpdateMovementComposeArgument;
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
public class MovementComposeService {

    private final MovementComposeRepository repository;
    private final QMovementCompose qMovementCompose = QMovementCompose.movementCompose;

    @Transactional
    public MovementCompose create(@NonNull CreateMovementComposeArgument argument) {
        return repository.save(MovementCompose.builder()
                                              .amount(argument.getAmount())
                                              .movement(argument.getMovement())
                                              .note(argument.getNote())
                                              .objectId(argument.getObjectId())
                                              .createDate(LocalDateTime.now())
                                              .updateDate(LocalDateTime.now())
                                              .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public MovementCompose update(@NonNull UUID id, @NonNull UpdateMovementComposeArgument argument) {
        MovementCompose existing = getExisting(id);

        existing.setMovement(argument.getMovement());
        existing.setNote(argument.getNote());
        existing.setAmount(argument.getAmount());
        existing.setObjectId(argument.getObjectId());
        existing.setUpdateDate(LocalDateTime.now());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public MovementCompose getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("MovementCompose.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<MovementCompose> list(@NonNull SearchMovementComposeArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<MovementCompose> page(@NonNull SearchMovementComposeArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchMovementComposeArgument argument) {
        return QPredicates.builder()
                          .add(argument.getMovement(), qMovementCompose.movement::eq)
                          .add(argument.getNote(), qMovementCompose.note::containsIgnoreCase)
                          .add(argument.getObjectId(), qMovementCompose.objectId::eq)
                          .add(argument.getAmount(), qMovementCompose.amount::eq)
                          .add(argument.isDeleted(), qMovementCompose.isDeleted::eq)
                          .add(argument.getCreateDateFrom(), qMovementCompose.createDate::goe)
                          .add(argument.getCreateDateTo(), qMovementCompose.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qMovementCompose.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qMovementCompose.updateDate::loe)
                          .buildAnd();
    }
}

