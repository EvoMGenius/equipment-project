package org.apatrios.api.equipment.movement_compose.internal.mapper;

import org.apatrios.action.equipment.movement_compose.create.CreateMovementComposeActionArgument;
import org.apatrios.action.equipment.movement_compose.update.UpdateMovementComposeActionArgument;
import org.apatrios.api.equipment.movement_compose.internal.dto.CreateMovementComposeDto;
import org.apatrios.api.equipment.movement_compose.internal.dto.MovementComposeDto;
import org.apatrios.api.equipment.movement_compose.internal.dto.SearchMovementComposeDto;
import org.apatrios.api.equipment.movement_compose.internal.dto.UpdateMovementComposeDto;
import org.apatrios.model.equipment.MovementCompose;
import org.apatrios.service.equipment.movement_compose.argument.SearchMovementComposeArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovementComposeMapper {
    MovementComposeMapper MOVEMENT_COMPOSE_MAPPER = Mappers.getMapper(MovementComposeMapper.class);

    MovementComposeDto toDto(MovementCompose movementCompose);

    CreateMovementComposeActionArgument toCreateArgument(CreateMovementComposeDto dto);

    UpdateMovementComposeActionArgument toUpdateArgument(UpdateMovementComposeDto dto);

    SearchMovementComposeArgument toSearchArgument(SearchMovementComposeDto dto);
}
