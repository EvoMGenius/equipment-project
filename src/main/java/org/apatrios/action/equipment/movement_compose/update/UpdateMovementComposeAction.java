package org.apatrios.action.equipment.movement_compose.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.Movement;
import org.apatrios.model.equipment.MovementCompose;
import org.apatrios.service.equipment.movement.MovementService;
import org.apatrios.service.equipment.movement_compose.MovementComposeService;
import org.apatrios.service.equipment.movement_compose.argument.UpdateMovementComposeArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateMovementComposeAction implements Action<UpdateMovementComposeActionArgument, MovementCompose> {

    MovementComposeService movementComposeService;
    MovementService movementService;

    @Override
    @Transactional
    public MovementCompose execute(@NonNull UpdateMovementComposeActionArgument argument) {
        Movement movement = movementService.getExisting(argument.getMovementId());

        return movementComposeService.update(argument.getId(),
                                             UpdateMovementComposeArgument.builder()
                                                                          .movement(movement)
                                                                          .amount(argument.getAmount())
                                                                          .note(argument.getNote())
                                                                          .objectId(argument.getObjectId())
                                                                          .franchiseeIds(argument.getFranchiseeIds())
                                                                          .build());
    }
}
