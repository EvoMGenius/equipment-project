package org.apatrios.service.management.telemetry;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.QTelemetry;
import org.apatrios.model.management.Telemetry;
import org.apatrios.repository.managment.TelemetryRepository;
import org.apatrios.service.management.telemetry.argument.CreateTelemetryArgument;
import org.apatrios.service.management.telemetry.argument.SearchTelemetryArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TelemetryService {

    private final TelemetryRepository repository;
    private final QTelemetry qTelemetry = QTelemetry.telemetry;

    @Transactional
    public Telemetry create(@NonNull CreateTelemetryArgument argument) {
        return repository.save(Telemetry.builder()
                                        .battery(argument.getBattery())
                                        .latitude(argument.getLatitude())
                                        .longitude(argument.getLongitude())
                                        .build());
    }


    @Transactional(readOnly = true)
    public Telemetry getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Telemetry.notFound"));
    }

    @Transactional(readOnly = true)
    public List<Telemetry> list(@NonNull SearchTelemetryArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    private Predicate buildPredicate(SearchTelemetryArgument argument) {
        return QPredicates.builder()
                          .add(argument.getBatteryMax(), qTelemetry.battery::loe)
                          .add(argument.getBatteryMin(), qTelemetry.battery::goe)
                          .add(argument.getLatitude(), qTelemetry.latitude::eq)
                          .add(argument.getLongitude(), qTelemetry.longitude::eq)
                          .buildAnd();
    }
}
