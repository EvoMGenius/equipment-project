package org.apatrios.action.movement.create;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class CreateMovementActionArgument {

    UUID pointFromId;

    UUID pointToId;

    LocalDateTime dateEnd;

    String note;
}
