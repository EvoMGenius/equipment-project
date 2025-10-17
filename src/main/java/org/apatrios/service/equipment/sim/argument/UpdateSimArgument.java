package org.apatrios.service.equipment.sim.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Operator;

@Value
@Builder
public class UpdateSimArgument {
    String phoneNumber;
    Operator operator;
}