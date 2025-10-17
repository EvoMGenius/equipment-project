package org.apatrios.service.equipment.movement_compose.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.Movement;

import java.util.UUID;

@Value
@Builder
public class UpdateMovementComposeArgument {

    Movement movement;

    UUID objectId;

    Integer amount;

    String note;
}
