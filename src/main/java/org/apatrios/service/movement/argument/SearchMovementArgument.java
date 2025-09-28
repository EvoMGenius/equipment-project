package org.apatrios.service.movement.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.MovementStatus;
import org.apatrios.model.dictoinary.Point;

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
