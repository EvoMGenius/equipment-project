package org.apatrios.service.equipment.sim_balance.argument;

import lombok.Builder;
import lombok.Value;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchSimBalanceArgument {
    Integer value;
    UUID simId;
    LocalDateTime createDateFrom;
    LocalDateTime createDateTo;
    LocalDateTime updateDateFrom;
    LocalDateTime updateDateTo;
    boolean isDeleted;
}