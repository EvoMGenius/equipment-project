package org.apatrios.action.movement.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.MovementStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class UpdateMovementActionArgument {
    UUID id;

    UUID pointFromId;

    UUID pointToId;

    LocalDateTime dateEnd;

    MovementStatus status;

    String note;
}
