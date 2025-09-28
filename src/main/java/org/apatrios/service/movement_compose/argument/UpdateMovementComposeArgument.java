package org.apatrios.service.movement_compose.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.Movement;

import java.util.UUID;

@Value
@Builder
public class UpdateMovementComposeArgument {

    Movement movement;

    UUID objectId;

    Integer amount;

    String note;
}
