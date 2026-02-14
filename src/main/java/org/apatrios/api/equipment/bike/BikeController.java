package org.apatrios.api.equipment.bike;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.equipment.bike.create.CreateBikeActionArgument;
import org.apatrios.api.equipment.bike.dto.BikeDto;
import org.apatrios.api.equipment.bike.dto.CreateBikeDto;
import org.apatrios.api.equipment.bike.dto.SearchBikeDto;
import org.apatrios.model.equipment.Bike;
import org.apatrios.service.equipment.bike.BikeService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.apatrios.api.equipment.bike.mapper.BikeMapper.BIKE_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equip/bike")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BikeController {

    Action<CreateBikeActionArgument, Bike> createBikeAction;
    BikeService service;

    @PostMapping
    public BikeDto create(@Valid @RequestBody CreateBikeDto dto) {
        return BIKE_MAPPER.toDto(createBikeAction.execute(BIKE_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public BikeDto get(@PathVariable UUID id) {
        return BIKE_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public CollectionDto<BikeDto> page(SearchBikeDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(BIKE_MAPPER.toSearchArgument(dto), pageable)
                                       .map(BIKE_MAPPER::toDto));
    }
}
