package org.apatrios.service.management.company.argument;

import lombok.Builder;
import org.apatrios.model.management.CompanyStatus;

import java.time.LocalDateTime;

@Builder
public record SearchCompanyArgument(
        String name,
        String inn,
        String address,
        String phone,
        String email,
        CompanyStatus status,
        Boolean isDeleted,
        LocalDateTime createDateFrom,
        LocalDateTime createDateTo,
        LocalDateTime updateDateFrom,
        LocalDateTime updateDateTo
) {}
