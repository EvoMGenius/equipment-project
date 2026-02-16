package org.apatrios.service.equipment.bike;

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
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BikeService {

    private final BikeRepository repository;
    private final QBike qBike = QBike.bike;

    @Transactional
    public Bike create(@NonNull CreateBikeArgument argument) {
        return repository.save(Bike.builder()
                                   .invNumber(argument.getInvNumber())
                                   .modelBike(argument.getModelBike())
                                   .chosenTariff(argument.getChosenTariff())
                                   .tariff(argument.getTariff())
                                   .chosenTariff(argument.getChosenTariff())
                                   .telemetry(argument.getTelemetry())
                                   .isAlarmOn(argument.getIsAlarmOn())
                                   .status(BikeStatus.CREATED)
                                   .isBlocked(argument.getIsBlocked())
                                   .isHeadlightsOn(argument.getIsHeadlightsOn())
                                   .build());
    }

    @Transactional(readOnly = true)
    public Page<Bike> page(@NonNull SearchBikeArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchBikeArgument argument) {
        return QPredicates.builder()
                          .add(argument.getModelBikeId(), qBike.modelBike.id::eq)
                          .add(argument.getChosenTariffId(), qBike.chosenTariff.id::eq)
                          .add(argument.getInvNumber(), qBike.invNumber::containsIgnoreCase)
                          .add(argument.getIsBlocked(), qBike.isBlocked::eq)
                          .add(argument.getStatus(), qBike.status::eq)
                          .add(argument.getTelemetryId(), qBike.telemetry.id::eq)
                          .add(argument.getIsAlarmOn(), qBike.isAlarmOn::eq)
                          .add(argument.getIsHeadlightsOn(), qBike.isHeadlightsOn::eq)
                          .add(argument.getTariffIds(), qBike.tariff.any().id::in)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Bike getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Bike.notFound"));
    }
}
