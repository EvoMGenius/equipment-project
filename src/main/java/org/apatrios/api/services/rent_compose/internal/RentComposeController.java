package org.apatrios.api.services.rent_compose.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.services.rent_compose.create.CreateRentComposeActionArgument;
import org.apatrios.action.services.rent_compose.update.UpdateRentComposeActionArgument;
import org.apatrios.api.services.rent_compose.internal.dto.CreateRentComposeDto;
import org.apatrios.api.services.rent_compose.internal.dto.RentComposeDto;
import org.apatrios.api.services.rent_compose.internal.dto.SearchRentComposeDto;
import org.apatrios.api.services.rent_compose.internal.dto.UpdateRentComposeDto;
import org.apatrios.model.services.RentCompose;
import org.apatrios.service.services.rent_compose.RentComposeService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.services.rent_compose.internal.mapper.RentComposeMapper.RENT_COMPOSE_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/rent-compose")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RentComposeController {

    RentComposeService service;
    Action<CreateRentComposeActionArgument, RentCompose> createRentComposeAction;
    Action<UpdateRentComposeActionArgument, RentCompose> updateRentComposeAction;

    @PostMapping("create")
    public RentComposeDto create(@Valid @RequestBody CreateRentComposeDto dto) {
        return RENT_COMPOSE_MAPPER.toDto(createRentComposeAction.execute(RENT_COMPOSE_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public RentComposeDto update(@Valid @RequestBody UpdateRentComposeDto dto) {
        return RENT_COMPOSE_MAPPER.toDto(updateRentComposeAction.execute(RENT_COMPOSE_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("list")
    public List<RentComposeDto> list(SearchRentComposeDto dto, Sort sort) {
        return service.list(RENT_COMPOSE_MAPPER.toSearchArgument(dto), sort)
                      .stream()
                      .map(RENT_COMPOSE_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<RentComposeDto> page(SearchRentComposeDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(RENT_COMPOSE_MAPPER.toSearchArgument(dto), pageable)
                                       .map(RENT_COMPOSE_MAPPER::toDto));
    }

    @PostMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
