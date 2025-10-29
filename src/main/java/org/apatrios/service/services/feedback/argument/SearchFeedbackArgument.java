package org.apatrios.service.services.feedback.argument;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class SearchFeedbackArgument {
    Integer rate;
    String note;
    String searchString;
    LocalDateTime createDateFrom;
    LocalDateTime createDateTo;
    LocalDateTime updateDateFrom;
    LocalDateTime updateDateTo;
    boolean isDeleted;
    UUID serviceDictionaryId;
    Set<UUID> franchiseeIds;
}
