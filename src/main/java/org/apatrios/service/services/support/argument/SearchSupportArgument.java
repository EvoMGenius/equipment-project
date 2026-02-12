package org.apatrios.service.services.support.argument;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Value
@Builder
public class SearchSupportArgument {
    LocalDateTime createDateFrom;

    LocalDateTime createDateTo;

    UUID typeId;

    String description;

    List<UUID> photoIds;

    UUID childRepairId;

    UUID statusId;
}
