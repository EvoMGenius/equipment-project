package org.apatrios.action.equipment.movement.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.Movement;
import org.apatrios.model.dictoinary.Point;
import org.apatrios.service.dictionary.PointService;
import org.apatrios.service.equipment.movement.MovementService;
import org.apatrios.service.equipment.movement.argument.CreateMovementArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateMovementAction implements Action<CreateMovementActionArgument, Movement> {

    PointService pointService;
    MovementService movementService;

    @Override
    @Transactional
    public Movement execute(@NonNull CreateMovementActionArgument argument) {
        Point pointFrom = pointService.getExisting(argument.getPointFromId());
        Point pointTo = pointService.getExisting(argument.getPointToId());

        return movementService.create(CreateMovementArgument.builder()
                                                            .note(argument.getNote())
                                                            .dateEnd(argument.getDateEnd())
                                                            .pointFrom(pointFrom)
                                                            .pointTo(pointTo)
                                                            .build());
    }
}
