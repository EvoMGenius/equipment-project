package org.apatrios.service.management.point.argument;

import lombok.Builder;
import org.apatrios.model.management.PointStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record SearchPointArgument(
        String name,
        String address,
        UUID companyId,
        UUID pointTypeId,
        PointStatus status,
        Boolean isDeleted,
        LocalDateTime createDateFrom,
        LocalDateTime createDateTo,
        LocalDateTime updateDateFrom,
        LocalDateTime updateDateTo
) {
}
