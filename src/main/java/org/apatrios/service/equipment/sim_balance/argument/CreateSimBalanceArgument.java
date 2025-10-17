package org.apatrios.service.equipment.sim_balance.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.Sim;
import java.time.LocalDateTime;

@Value
@Builder
public class CreateSimBalanceArgument {
    Integer value;
    Sim sim;
    LocalDateTime createDate;
}