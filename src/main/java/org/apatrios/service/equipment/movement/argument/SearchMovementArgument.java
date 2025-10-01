package org.apatrios.service.equipment.movement.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.MovementStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchMovementArgument {

    UUID pointFromId;

    UUID pointToId;

    LocalDateTime dateEnd;

    LocalDateTime createDate;

    MovementStatus status;

    String note;
}
