package org.apatrios.service.services.repair.argument;

import lombok.Builder;
import org.apatrios.model.services.RepairStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record SearchRepairArgument(
        String searchString,
        String number,
        String fixType,
        String problem,
        RepairStatus status,
        LocalDateTime createDateFrom,
        LocalDateTime createDateTo,
        UUID pointId
) {}
