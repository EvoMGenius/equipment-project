package org.apatrios.service.equipment.iot.argument;

import lombok.Builder;
import org.apatrios.model.dictoinary.IotModel;
import org.apatrios.model.management.Company;

import java.util.UUID;

@Builder
public record CreateIotArgument(
        IotModel iotModel,
        String invNumber,
        Company company,
        String imei,
        UUID simId,
        String comment
) {}
