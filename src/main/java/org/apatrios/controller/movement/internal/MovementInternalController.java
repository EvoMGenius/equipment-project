package org.apatrios.controller.movement.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.movement.create.CreateMovementAction;
import org.apatrios.action.movement.update.UpdateMovementAction;
import org.apatrios.controller.movement.internal.dto.CreateMovementDto;
import org.apatrios.controller.movement.internal.dto.MovementDto;
import org.apatrios.controller.movement.internal.dto.SearchMovementDto;
import org.apatrios.controller.movement.internal.dto.UpdateMovementDto;
import org.apatrios.service.movement.MovementService;
import org.apatrios.service.movement.argument.SearchMovementArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.controller.movement.internal.mapper.MovementMapper.MOVEMENT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/movement")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MovementInternalController {

    CreateMovementAction createMovementAction;
    UpdateMovementAction updateMovementAction;
    MovementService service;

    @PostMapping("create")
    public MovementDto create(@Valid @RequestBody CreateMovementDto dto) {
        return MOVEMENT_MAPPER.toDto(createMovementAction.execute(MOVEMENT_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public MovementDto update(@Valid @RequestBody UpdateMovementDto dto) {
        return MOVEMENT_MAPPER.toDto(updateMovementAction.execute(MOVEMENT_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("list")
    public List<MovementDto> list(SearchMovementDto dto, Sort sort) {
        SearchMovementArgument argument = MOVEMENT_MAPPER.toSearchArgument(dto);
        return service.list(argument, sort)
                      .stream()
                      .map(MOVEMENT_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<MovementDto> page(SearchMovementDto dto, Pageable pageable) {
        SearchMovementArgument argument = MOVEMENT_MAPPER.toSearchArgument(dto);
        return CollectionDto.of(service.page(argument, pageable).map(MOVEMENT_MAPPER::toDto));
    }

    @DeleteMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
