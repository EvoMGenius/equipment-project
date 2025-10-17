package org.apatrios.service.equipment.movement_compose.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.Movement;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchMovementComposeArgument {

    Movement movement;

    UUID objectId;

    Integer amount;

    String note;

    LocalDateTime createDateFrom;

    LocalDateTime createDateTo;

    LocalDateTime updateDateFrom;

    LocalDateTime updateDateTo;

    boolean isDeleted;
}
