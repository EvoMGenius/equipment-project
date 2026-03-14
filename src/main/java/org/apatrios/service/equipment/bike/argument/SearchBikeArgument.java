package org.apatrios.service.equipment.bike.argument;

import lombok.Builder;
import org.apatrios.model.equipment.BikeStatus;

import java.util.UUID;

@Builder
public record SearchBikeArgument(
        UUID modelBikeId,
        UUID companyId,
        Integer seqNumber,
        Integer invNumber,
        String vin,
        String motorWheel,
        UUID iotId,
        String comment,
        BikeStatus status,
        Boolean isDeleted
) {}
