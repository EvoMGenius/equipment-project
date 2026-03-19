package org.apatrios.action.equipment.bike.create.argument;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateBikeActionArgument(
        UUID modelBikeId,
        UUID companyId,
        Integer seqNumber,
        Integer invNumber,
        String vin,
        String motorWheel,
        UUID iotId,
        String comment
) {}

