package org.apatrios.api.services.rent;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.services.rent.create.CreateRentActionArgument;
import org.apatrios.api.services.rent.dto.CreateRentDto;
import org.apatrios.api.services.rent.dto.RentDto;
import org.apatrios.api.services.rent.dto.SearchRentDto;
import org.apatrios.model.services.Rent;
import org.apatrios.service.services.rent.RentService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.apatrios.api.services.rent.mapper.RentMapper.RENT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service/rent")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RentController {

    RentService service;
    Action<CreateRentActionArgument, Rent> createRentAction;

    @PostMapping
    public RentDto create(@Valid @RequestBody CreateRentDto dto) {
        return RENT_MAPPER.toDto(createRentAction.execute(RENT_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public RentDto get(@PathVariable UUID id) {
        return RENT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public CollectionDto<RentDto> page(SearchRentDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(RENT_MAPPER.toSearchArgument(dto), pageable)
                                       .map(RENT_MAPPER::toDto));
    }
}
