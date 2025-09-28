package org.apatrios.action.movement_compose.create;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CreateMovementComposeActionArgument {

    UUID movementId;

    UUID objectId;

    Integer amount;

    String note;
}
