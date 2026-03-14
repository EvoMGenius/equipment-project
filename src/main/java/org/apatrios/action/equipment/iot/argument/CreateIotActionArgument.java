package org.apatrios.action.equipment.iot.argument;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateIotActionArgument(
        UUID iotModelId,
        String invNumber,
        UUID companyId,
        String imei,
        UUID simId,
        String comment
) {}
