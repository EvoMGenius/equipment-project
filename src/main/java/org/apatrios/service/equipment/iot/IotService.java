package org.apatrios.service.equipment.iot;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.model.equipment.BikeStatus;
import org.apatrios.model.equipment.Iot;
import org.apatrios.model.equipment.IotStatus;
import org.apatrios.model.equipment.QIot;
import org.apatrios.repository.equipment.IotRepository;
import org.apatrios.service.equipment.iot.argument.CreateIotArgument;
import org.apatrios.service.equipment.iot.argument.SearchIotArgument;
import org.apatrios.service.equipment.iot.argument.UpdateIotArgument;
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
public class IotService {

    private final IotRepository repository;
    private final QIot qIot = QIot.iot;

    @Transactional
    public Iot create(@NonNull CreateIotArgument argument) {
        return repository.save(Iot.builder()
                                  .model(argument.getModel())
                                  .invNumber(argument.getInvNumber())
                                  .sim(argument.getSim())
                                  .status(IotStatus.NEW)
                                  .comment(argument.getComment())
                                  .createDate(LocalDateTime.now())
                                  .updateDate(LocalDateTime.now())
                                  .imei(argument.getImei())
                                  .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Iot update(@NonNull UUID id, @NonNull UpdateIotArgument argument) {
        Iot existing = getExisting(id);

        existing.setModel(argument.getModel());
        existing.setInvNumber(argument.getInvNumber());
        existing.setSim(argument.getSim());
        existing.setStatus(argument.getStatus());
        existing.setComment(argument.getComment());
        existing.setImei(argument.getImei());
        existing.setUpdateDate(LocalDateTime.now());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Iot> list(@NonNull SearchIotArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Iot> page(@NonNull SearchIotArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchIotArgument argument) {
        return QPredicates.builder()
                          .add(argument.getModelId(), qIot.model.id::eq)
                          .add(argument.getInvNumber(), qIot.invNumber::containsIgnoreCase)
                          .add(argument.getSimId(), qIot.sim.id::eq)
                          .add(argument.getStatus(), qIot.status::eq)
                          .add(argument.getComment(), qIot.comment::containsIgnoreCase)
                          .add(argument.getCreateDateFrom(), qIot.createDate::goe)
                          .add(argument.getCreateDateTo(), qIot.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qIot.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qIot.updateDate::loe)
                          .add(argument.isDeleted(), qIot.isDeleted::eq)
                          .add(argument.getImei(), qIot.imei::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Iot getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Iot.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        repository.deleteById(id);
    }
}