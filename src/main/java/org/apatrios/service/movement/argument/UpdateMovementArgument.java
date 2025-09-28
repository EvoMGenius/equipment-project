package org.apatrios.service.movement.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.MovementStatus;
import org.apatrios.model.dictoinary.Point;

import java.time.LocalDateTime;

@Value
@Builder
public class UpdateMovementArgument {

    Point pointFrom;

    Point pointTo;

    LocalDateTime dateEnd;

    MovementStatus status;

    String note;
}
