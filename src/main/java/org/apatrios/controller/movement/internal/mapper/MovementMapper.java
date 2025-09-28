package org.apatrios.controller.movement.internal.mapper;

import org.apatrios.action.movement.create.CreateMovementActionArgument;
import org.apatrios.action.movement.update.UpdateMovementActionArgument;
import org.apatrios.controller.movement.internal.dto.CreateMovementDto;
import org.apatrios.controller.movement.internal.dto.MovementDto;
import org.apatrios.controller.movement.internal.dto.SearchMovementDto;
import org.apatrios.controller.movement.internal.dto.UpdateMovementDto;
import org.apatrios.model.Movement;
import org.apatrios.service.movement.argument.SearchMovementArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovementMapper {
    MovementMapper MOVEMENT_MAPPER = Mappers.getMapper(MovementMapper.class);

    MovementDto toDto(Movement movement);

    CreateMovementActionArgument toCreateArgument(CreateMovementDto dto);

    UpdateMovementActionArgument toUpdateArgument(UpdateMovementDto dto);

    SearchMovementArgument toSearchArgument(SearchMovementDto dto);
}
