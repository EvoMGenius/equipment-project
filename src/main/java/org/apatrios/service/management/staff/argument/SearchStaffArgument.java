package org.apatrios.service.management.staff.argument;

import lombok.Builder;
import org.apatrios.model.management.StaffStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record SearchStaffArgument(
        String surname,
        String name,
        String position,
        UUID companyId,
        String phone,
        String email,
        StaffStatus status,
        Boolean isDeleted,
        LocalDateTime createDateFrom,
        LocalDateTime createDateTo,
        LocalDateTime updateDateFrom,
        LocalDateTime updateDateTo
) {}
