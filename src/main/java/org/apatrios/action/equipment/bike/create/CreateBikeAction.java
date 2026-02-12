package org.apatrios.action.equipment.bike.create;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.Status;
import org.apatrios.model.equipment.Bike;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.management.Tariff;
import org.apatrios.model.management.Telemetry;
import org.apatrios.service.equipment.bike.BikeService;
import org.apatrios.service.equipment.bike.argument.CreateBikeArgument;
import org.apatrios.service.dictionary.ModelBikeService;
import org.apatrios.service.equipment.status.StatusService;
import org.apatrios.service.management.tariff.TariffService;
import org.apatrios.service.management.telemetry.TelemetryService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class CreateBikeAction implements Action<CreateBikeActionArgument, Bike> {

    BikeService bikeService;
    TariffService tariffService;
    ModelBikeService modelBikeService;
    TelemetryService telemetryService;
    StatusService statusService;

    @Override
    @Transactional
    public Bike execute(@NonNull CreateBikeActionArgument argument) {
        Tariff tariff = tariffService.getExisting(argument.getChosenTariffId());
        List<Tariff> tariffs = tariffService.getAllByIds(argument.getTariffIds());
        Telemetry telemetry = telemetryService.getExisting(argument.getTelemetryId());
        Status status = statusService.getExisting(argument.getStatusId());
        ModelBike modelBike = modelBikeService.getExisting(argument.getModelBikeId());

        return bikeService.create(CreateBikeArgument.builder()
                                                    .chosenTariff(tariff)
                                                    .tariff(tariffs)
                                                    .telemetry(telemetry)
                                                    .status(status)
                                                    .invNumber(argument.getInvNumber())
                                                    .modelBike(modelBike)
                                                    // todo integration with monitoring service
                                                    .isAlarmOn(false)
                                                    .isBlocked(false)
                                                    .isHeadlightsOn(false)
                                                    .build());
    }
}
