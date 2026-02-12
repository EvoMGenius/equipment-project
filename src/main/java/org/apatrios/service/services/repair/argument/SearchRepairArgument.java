package org.apatrios.service.services.repair.argument;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Value
@Builder
public class SearchRepairArgument {
    String searchString;
    String number;
    UUID fixTypeId;
    String problem;
    UUID statusId;
    LocalDateTime createDateFrom;
    LocalDateTime createDateTo;
    UUID pointId;
    List<UUID> photoIds;
}
