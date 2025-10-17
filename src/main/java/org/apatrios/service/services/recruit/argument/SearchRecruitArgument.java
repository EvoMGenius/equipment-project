package org.apatrios.service.services.recruit.argument;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchRecruitArgument {
    UUID clientId;

    LocalDateTime createDateFrom;

    LocalDateTime createDateTo;

    LocalDateTime updateDateFrom;

    LocalDateTime updateDateTo;

    boolean isDeleted;
}
