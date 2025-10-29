package org.apatrios.action.equipment.movement_compose.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.Movement;
import org.apatrios.model.equipment.MovementCompose;
import org.apatrios.service.equipment.movement.MovementService;
import org.apatrios.service.equipment.movement_compose.MovementComposeService;
import org.apatrios.service.equipment.movement_compose.argument.CreateMovementComposeArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateMovementComposeAction implements Action<CreateMovementComposeActionArgument, MovementCompose> {

    MovementComposeService movementComposeService;
    MovementService movementService;

    @Override
    @Transactional
    public MovementCompose execute(@NonNull CreateMovementComposeActionArgument argument) {
        Movement movement = movementService.getExisting(argument.getMovementId());

        return movementComposeService.create(CreateMovementComposeArgument.builder()
                                                                          .movement(movement)
                                                                          .amount(argument.getAmount())
                                                                          .note(argument.getNote())
                                                                          .objectId(argument.getObjectId())
                                                                          .franchiseeIds(argument.getFranchiseeIds())
                                                                          .build());
    }
}
