package org.apatrios.service.services.recruit.argument;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchRecruitArgument {
    String searchString;
    String recruitCompanyName;
    LocalDateTime startDate;
    LocalDateTime endDate;
    UUID statusId;
}
