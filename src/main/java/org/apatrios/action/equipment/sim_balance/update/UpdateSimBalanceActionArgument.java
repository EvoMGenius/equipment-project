package org.apatrios.action.equipment.sim_balance.update;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class UpdateSimBalanceActionArgument {
    UUID id;
    Integer value;
    UUID simId;
}
