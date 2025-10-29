package org.apatrios.service.equipment.bike;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.equipment.Bike;
import org.apatrios.model.equipment.BikeStatus;
import org.apatrios.model.equipment.QBike;
import org.apatrios.repository.equipment.BikeRepository;
import org.apatrios.service.equipment.bike.argument.CreateBikeArgument;
import org.apatrios.service.equipment.bike.argument.SearchBikeArgument;
import org.apatrios.service.equipment.bike.argument.UpdateBikeArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BikeService {

    private final BikeRepository repository;
    private final QBike qBike = QBike.bike;

    @Transactional
    public Bike create(@NonNull CreateBikeArgument argument) {
        return repository.save(Bike.builder()
                                   .iot(argument.getIot())
                                   .vin(argument.getVin())
                                   .status(BikeStatus.NEW)
                                   .modelBike(argument.getModelBike())
                                   .invNumber(argument.getInvNumber())
                                   .seqNumber(argument.getSeqNumber())
                                   .motorWheel(argument.getMotorWheel())
                                   .comment(argument.getComment())
                                   .franchisee(argument.getFranchisee())
                                   .createDate(LocalDateTime.now())
                                   .updateDate(LocalDateTime.now())
                                   .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Bike update(@NonNull UUID id, @NonNull UpdateBikeArgument argument) {
        Bike existing = getExisting(id);

        existing.setIot(argument.getIot());
        existing.setInvNumber(argument.getInvNumber());
        existing.setVin(argument.getVin());
        existing.setModelBike(argument.getModelBike());
        existing.setStatus(argument.getStatus());
        existing.setSeqNumber(argument.getSeqNumber());
        existing.setMotorWheel(argument.getMotorWheel());
        existing.setComment(argument.getComment());
        existing.setFranchisee(argument.getFranchisee());
        existing.setUpdateDate(LocalDateTime.now());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Bike> list(@NonNull SearchBikeArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Bike> page(@NonNull SearchBikeArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchBikeArgument argument) {
        return QPredicates.builder()
                          .add(argument.getModelBikeId(), qBike.modelBike.id::eq)
                          .add(argument.getIotId(), qBike.iot.id::eq)
                          .add(argument.getMotorWheel(), qBike.motorWheel::containsIgnoreCase)
                          .add(argument.getSeqNumber(), qBike.seqNumber::eq)
                          .add(argument.getComment(), qBike.comment::containsIgnoreCase)
                          .add(argument.getStatus(), qBike.status::eq)
                          .add(argument.getFranchiseeId(), qBike.franchisee.id::eq)
                          .add(argument.isDeleted(), qBike.isDeleted::eq)
                          .add(argument.getCreateDateFrom(), qBike.createDate::goe)
                          .add(argument.getCreateDateTo(), qBike.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qBike.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qBike.updateDate::loe)
                          .addAnyString(argument.getSearchString(),
                                        qBike.franchisee.franchiseeProfile.name::containsIgnoreCase,
                                        qBike.invNumber.stringValue()::containsIgnoreCase,
                                        qBike.vin::containsIgnoreCase,
                                        qBike.motorWheel::containsIgnoreCase,
                                        qBike.seqNumber.stringValue()::containsIgnoreCase,
                                        qBike.status.stringValue()::containsIgnoreCase,
                                        qBike.comment::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Bike getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Bike.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        repository.deleteById(id);
    }
}
