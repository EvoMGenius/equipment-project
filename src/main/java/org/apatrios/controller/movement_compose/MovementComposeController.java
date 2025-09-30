package org.apatrios.controller.movement_compose;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.movement_compose.create.CreateMovementComposeActionArgument;
import org.apatrios.action.movement_compose.update.UpdateMovementComposeActionArgument;
import org.apatrios.controller.movement_compose.dto.CreateMovementComposeDto;
import org.apatrios.controller.movement_compose.dto.MovementComposeDto;
import org.apatrios.controller.movement_compose.dto.SearchMovementComposeDto;
import org.apatrios.controller.movement_compose.dto.UpdateMovementComposeDto;
import org.apatrios.model.MovementCompose;
import org.apatrios.service.movement_compose.MovementComposeService;
import org.apatrios.service.movement_compose.argument.SearchMovementComposeArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.controller.movement_compose.mapper.MovementComposeMapper.MOVEMENT_COMPOSE_MAPPER;

@RestController
@RequestMapping("internal/movement-compose")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MovementComposeController {

    MovementComposeService service;
    Action<CreateMovementComposeActionArgument, MovementCompose> createMovementComposeAction;
    Action<UpdateMovementComposeActionArgument, MovementCompose> updateMovementComposeAction;

    @PostMapping("create")
    public MovementComposeDto create(@Valid @RequestBody CreateMovementComposeDto dto) {
        return MOVEMENT_COMPOSE_MAPPER.toDto(createMovementComposeAction.execute(MOVEMENT_COMPOSE_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public MovementComposeDto update(@Valid @RequestBody UpdateMovementComposeDto dto) {
        return MOVEMENT_COMPOSE_MAPPER.toDto(updateMovementComposeAction.execute(MOVEMENT_COMPOSE_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("list")
    public List<MovementComposeDto> list(SearchMovementComposeDto dto, Sort sort) {
        SearchMovementComposeArgument argument = MOVEMENT_COMPOSE_MAPPER.toSearchArgument(dto);
        return service.list(argument, sort)
                      .stream()
                      .map(MOVEMENT_COMPOSE_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<MovementComposeDto> page(SearchMovementComposeDto dto, Pageable pageable) {
        SearchMovementComposeArgument argument = MOVEMENT_COMPOSE_MAPPER.toSearchArgument(dto);
        return CollectionDto.of(service.page(argument, pageable).map(MOVEMENT_COMPOSE_MAPPER::toDto));
    }

    @DeleteMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
