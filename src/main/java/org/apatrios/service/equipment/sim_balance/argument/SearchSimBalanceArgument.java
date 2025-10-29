package org.apatrios.service.equipment.sim_balance.argument;

import lombok.Builder;
import lombok.Value;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class SearchSimBalanceArgument {
    Integer value;
    UUID simId;
    String searchString;
    LocalDateTime createDateFrom;
    LocalDateTime createDateTo;
    LocalDateTime updateDateFrom;
    LocalDateTime updateDateTo;
    boolean isDeleted;
    Set<UUID> franchiseeIds;
}