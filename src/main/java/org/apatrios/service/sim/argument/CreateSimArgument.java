package org.apatrios.service.sim.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Operator;

@Value
@Builder
public class CreateSimArgument {
    String phoneNumber;
    Operator operator;
}