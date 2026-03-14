package org.apatrios.service.services.support.argument;

import lombok.Builder;
import org.apatrios.model.services.SupportStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record SearchSupportArgument(
        LocalDateTime createDateFrom,
        LocalDateTime createDateTo,
        String type,
        String description,
        UUID childRepairId,
        SupportStatus status
) {}