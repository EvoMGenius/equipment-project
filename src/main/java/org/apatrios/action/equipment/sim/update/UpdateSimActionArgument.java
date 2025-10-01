package org.apatrios.action.equipment.sim.update;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class UpdateSimActionArgument {
    UUID id;
    String phoneNumber;
    UUID operatorId;
}
