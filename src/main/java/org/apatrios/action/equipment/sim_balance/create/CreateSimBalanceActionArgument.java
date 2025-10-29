package org.apatrios.action.equipment.sim_balance.create;

import lombok.Builder;
import lombok.Value;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateSimBalanceActionArgument {
    Integer value;
    UUID simId;
    Set<UUID> franchiseeIds;
}
