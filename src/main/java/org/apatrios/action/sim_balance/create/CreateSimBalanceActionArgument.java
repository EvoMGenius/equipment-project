package org.apatrios.action.sim_balance.create;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class CreateSimBalanceActionArgument {
    Integer value;
    UUID simId;
    LocalDateTime createDate;
}
