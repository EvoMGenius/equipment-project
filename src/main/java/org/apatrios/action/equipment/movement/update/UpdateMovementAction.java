package org.apatrios.action.equipment.movement.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.Movement;
import org.apatrios.model.dictoinary.Point;
import org.apatrios.service.dictionary.PointService;
import org.apatrios.service.equipment.movement.MovementService;
import org.apatrios.service.equipment.movement.argument.UpdateMovementArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateMovementAction implements Action<UpdateMovementActionArgument, Movement> {

    MovementService movementService;
    PointService pointService;

    @Override
    @Transactional
    public Movement execute(@NonNull UpdateMovementActionArgument argument) {
        Point pointFrom = argument.getPointFromId() != null
                          ? pointService.getExisting(argument.getPointFromId())
                          : null;

        Point pointTo = argument.getPointToId() != null
                        ? pointService.getExisting(argument.getPointToId())
                        : null;

        return movementService.update(argument.getId(),
                                      UpdateMovementArgument.builder()
                                                            .pointTo(pointTo)
                                                            .pointFrom(pointFrom)
                                                            .dateEnd(argument.getDateEnd())
                                                            .note(argument.getNote())
                                                            .status(argument.getStatus())
                                                            .build());
    }
}
