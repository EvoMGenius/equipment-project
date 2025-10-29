package org.apatrios.action.equipment.movement.create;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateMovementActionArgument {
    UUID pointFromId;
    UUID pointToId;
    LocalDateTime dateEnd;
    String note;
    Set<UUID> franchiseeIds;
}
