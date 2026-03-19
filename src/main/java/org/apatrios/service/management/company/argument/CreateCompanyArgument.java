package org.apatrios.service.management.company.argument;

import lombok.Builder;

@Builder
public record CreateCompanyArgument(
        String name,
        String inn,
        String address,
        String phone,
        String email
) {}
