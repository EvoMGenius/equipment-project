package org.apatrios.service.services.recruit.argument;

import lombok.Builder;

@Builder
public record CreateRecruitArgument(
        String recruitCompanyName
) {
}
