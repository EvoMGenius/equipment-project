package org.apatrios.action.equipment.movement_compose.update;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class UpdateMovementComposeActionArgument {
    UUID id;

    UUID movementId;

    UUID objectId;

    Integer amount;

    String note;
}
