package org.apatrios.action.equipment.sim.create;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CreateSimActionArgument {
    String phoneNumber;
    UUID operatorId;
}
