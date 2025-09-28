package org.apatrios.controller.movement_compose.mapper;

import org.apatrios.action.movement_compose.create.CreateMovementComposeActionArgument;
import org.apatrios.action.movement_compose.update.UpdateMovementComposeActionArgument;
import org.apatrios.controller.movement_compose.dto.CreateMovementComposeDto;
import org.apatrios.controller.movement_compose.dto.MovementComposeDto;
import org.apatrios.controller.movement_compose.dto.SearchMovementComposeDto;
import org.apatrios.controller.movement_compose.dto.UpdateMovementComposeDto;
import org.apatrios.model.MovementCompose;
import org.apatrios.service.movement_compose.argument.SearchMovementComposeArgument;
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
