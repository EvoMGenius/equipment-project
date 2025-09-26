package org.apatrios.service.simbalance.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.Sim;
import java.time.LocalDateTime;

@Value
@Builder
public class CreateSimBalanceArgument {
    Integer value;
    Sim sim;
    LocalDateTime createDate;
}