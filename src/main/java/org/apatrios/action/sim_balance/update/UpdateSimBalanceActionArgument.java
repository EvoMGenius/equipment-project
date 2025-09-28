package org.apatrios.action.sim_balance.update;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class UpdateSimBalanceActionArgument {
    UUID id;
    Integer value;
    UUID simId;
    LocalDateTime createDate;
}
