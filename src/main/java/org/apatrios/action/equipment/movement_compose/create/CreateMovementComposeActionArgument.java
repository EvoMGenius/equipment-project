package org.apatrios.action.equipment.movement_compose.create;

import lombok.Builder;
import lombok.Value;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateMovementComposeActionArgument {
    UUID movementId;
    UUID objectId;
    Integer amount;
    String note;
    Set<UUID> franchiseeIds;
}
