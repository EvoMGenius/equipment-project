package org.apatrios.service.management.staff.argument;

import lombok.Builder;
import org.apatrios.model.management.Company;

@Builder
public record CreateStaffArgument(
        String surname,
        String name,
        String position,
        Company company,
        String phone,
        String email
) {
}
