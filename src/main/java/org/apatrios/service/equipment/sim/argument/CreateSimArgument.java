package org.apatrios.service.equipment.sim.argument;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateSimArgument {
    String phoneNumber;
}