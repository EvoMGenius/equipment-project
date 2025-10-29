package org.apatrios.service.equipment.movement.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.MovementStatus;
import org.apatrios.model.dictoinary.Point;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class UpdateMovementArgument {

    Point pointFrom;

    Point pointTo;

    Set<UUID> franchiseeIds;

    LocalDateTime dateEnd;

    MovementStatus status;

    String note;
}
