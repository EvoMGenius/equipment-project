package org.apatrios.service.equipment.iot.argument;

import lombok.Builder;
import org.apatrios.model.equipment.IotStatus;

import java.util.UUID;

@Builder
public record SearchIotArgument(
        UUID modelId,
        String invNumber,
        String imei,
        Boolean isDeleted,
        IotStatus status,
        UUID companyId
) {
}
