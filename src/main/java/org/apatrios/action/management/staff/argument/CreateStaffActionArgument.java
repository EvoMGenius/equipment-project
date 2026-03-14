package org.apatrios.action.management.staff.argument;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateStaffActionArgument(
        String surname,
        String name,
        String position,
        UUID companyId,
        String phone,
        String email
) {
}
