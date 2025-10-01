package org.apatrios.api.equipment.movement.internal.mapper;

import org.apatrios.action.equipment.movement.create.CreateMovementActionArgument;
import org.apatrios.action.equipment.movement.update.UpdateMovementActionArgument;
import org.apatrios.api.equipment.movement.internal.dto.CreateMovementDto;
import org.apatrios.api.equipment.movement.internal.dto.MovementDto;
import org.apatrios.api.equipment.movement.internal.dto.SearchMovementDto;
import org.apatrios.api.equipment.movement.internal.dto.UpdateMovementDto;
import org.apatrios.model.equipment.Movement;
import org.apatrios.service.equipment.movement.argument.SearchMovementArgument;
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
