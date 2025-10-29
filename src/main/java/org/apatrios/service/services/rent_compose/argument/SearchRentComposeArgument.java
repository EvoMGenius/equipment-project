package org.apatrios.service.services.rent_compose.argument;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class SearchRentComposeArgument {
    UUID rentId;
    Integer amount;
    String searchString;
    UUID objectId;
    LocalDateTime createDateFrom;
    LocalDateTime createDateTo;
    LocalDateTime updateDateFrom;
    LocalDateTime updateDateTo;
    boolean isDeleted;
    Set<UUID> franchiseeIds;
}
