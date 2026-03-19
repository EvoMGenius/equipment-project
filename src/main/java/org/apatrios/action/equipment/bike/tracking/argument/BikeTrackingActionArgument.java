package org.apatrios.action.equipment.bike.tracking.argument;

import lombok.Builder;
import org.apatrios.feign.tracking.TrackingService;

import java.util.UUID;
import java.util.function.BiConsumer;

@Builder
public record BikeTrackingActionArgument(
        UUID bikeId,
        BiConsumer<TrackingService, UUID> operation
) {
}
