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

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BikeService {

    private final BikeRepository repository;
    private final QBike qBike = QBike.bike;

    @Transactional
    public Bike create(@NonNull CreateBikeArgument argument) {
        return repository.save(Bike.builder()
                                   .invNumber(argument.invNumber())
                                   .seqNumber(argument.seqNumber())
                                   .company(argument.company())
                                   .motorWheel(argument.motorWheel())
                                   .isDeleted(argument.isDeleted())
                                   .modelBike(argument.modelBike())
                                   .iot(argument.iot())
                                   .vin(argument.vin())
                                   .comment(argument.comment())
                                   .status(BikeStatus.CREATED)
                                   .build());
    }

    @Transactional(readOnly = true)
    public Page<Bike> page(@NonNull SearchBikeArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchBikeArgument argument) {
        return QPredicates.builder()
                          .add(argument.invNumber(), qBike.invNumber::eq)
                          .add(argument.modelBikeId(), qBike.modelBike.id::eq)
                          .add(argument.companyId(), qBike.company.id::eq)
                          .add(argument.vin(), qBike.vin::containsIgnoreCase)
                          .add(argument.motorWheel(), qBike.motorWheel::containsIgnoreCase)
                          .add(argument.iotId(), qBike.iot.id::eq)
                          .add(argument.status(), qBike.status::eq)
                          .add(argument.isDeleted(), qBike.isDeleted::eq)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Bike getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Bike.notFound"));
    }
}
