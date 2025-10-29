package org.apatrios.api.services.rent.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.services.rent.create.CreateRentActionArgument;
import org.apatrios.action.services.rent.update.UpdateRentActionArgument;
import org.apatrios.api.services.rent.internal.dto.CreateRentDto;
import org.apatrios.api.services.rent.internal.dto.RentDto;
import org.apatrios.api.services.rent.internal.dto.SearchRentDto;
import org.apatrios.api.services.rent.internal.dto.UpdateRentDto;
import org.apatrios.model.services.Rent;
import org.apatrios.service.services.rent.RentService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.services.rent.internal.mapper.RentMapper.RENT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/rent")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RentController {

    RentService service;
    Action<CreateRentActionArgument, Rent> createRentAction;
    Action<UpdateRentActionArgument, Rent> updateRentAction;

    @PostMapping("create")
    public RentDto create(@Valid @RequestBody CreateRentDto dto) {
        return RENT_MAPPER.toDto(createRentAction.execute(RENT_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public RentDto update(@Valid @RequestBody UpdateRentDto dto) {
        return RENT_MAPPER.toDto(updateRentAction.execute(RENT_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("{id}")
    public RentDto get(@PathVariable UUID id) {
        return RENT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("list")
    public List<RentDto> list(SearchRentDto dto, Sort sort) {
        return service.list(RENT_MAPPER.toSearchArgument(dto), sort)
                      .stream()
                      .map(RENT_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<RentDto> page(SearchRentDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(RENT_MAPPER.toSearchArgument(dto), pageable)
                                       .map(RENT_MAPPER::toDto));
    }

    @PostMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
