package org.apatrios.service.services.recruit.argument;

import lombok.Builder;
import org.apatrios.model.services.RecruitStatus;

import java.time.LocalDateTime;

@Builder
public record SearchRecruitArgument(
        String searchString,
        String recruitCompanyName,
        LocalDateTime startDate,
        LocalDateTime endDate,
        RecruitStatus status
) {
}
