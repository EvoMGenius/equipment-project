package org.apatrios.action.equipment.bike.tracking;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.action.VoidAction;
import org.apatrios.action.equipment.bike.tracking.argument.BikeTrackingActionArgument;
import org.apatrios.feign.tracking.TrackingService;
import org.apatrios.service.equipment.bike.BikeService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BikeTrackingAction implements VoidAction<BikeTrackingActionArgument> {

    private final BikeService bikeService;
    private final TrackingService trackingService;

    @Override
    @Transactional
    public void execute(@NonNull BikeTrackingActionArgument argument) {
        UUID iotId = bikeService.getExisting(argument.bikeId()).getIot().getId();

        argument.operation().accept(trackingService, iotId);
    }
}
