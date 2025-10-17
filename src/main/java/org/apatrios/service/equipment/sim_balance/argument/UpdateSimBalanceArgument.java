package org.apatrios.service.equipment.sim_balance.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.Sim;

@Value
@Builder
public class UpdateSimBalanceArgument {
    Integer value;
    Sim sim;
}