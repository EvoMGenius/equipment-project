package org.apatrios.service.equipment.sim_balance.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.Sim;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateSimBalanceArgument {
    Integer value;
    Sim sim;
    Set<UUID> franchiseeIds;
}