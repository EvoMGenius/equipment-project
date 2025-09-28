package org.apatrios.action.movement.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.Movement;
import org.apatrios.model.dictoinary.Point;
import org.apatrios.service.dictionary.PointService;
import org.apatrios.service.movement.MovementService;
import org.apatrios.service.movement.argument.UpdateMovementArgument;
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
        Point from = pointService.getExisting(argument.getPointFromId());
        Point to = pointService.getExisting(argument.getPointToId());

        return movementService.update(argument.getId(),
                                      UpdateMovementArgument.builder()
                                                            .pointTo(to)
                                                            .pointFrom(from)
                                                            .dateEnd(argument.getDateEnd())
                                                            .note(argument.getNote())
                                                            .status(argument.getStatus())
                                                            .build());
    }
}
