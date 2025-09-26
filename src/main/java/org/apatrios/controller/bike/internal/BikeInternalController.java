package org.apatrios.controller.bike.internal;

import lombok.RequiredArgsConstructor;
import org.apatrios.controller.bike.internal.dto.BikeDto;
import org.apatrios.controller.bike.internal.dto.CreateBikeDto;
import org.apatrios.controller.bike.internal.dto.SearchBikeDto;
import org.apatrios.controller.bike.internal.dto.UpdateBikeDto;
import org.apatrios.service.bike.BikeService;
import org.apatrios.service.bike.argument.CreateBikeArgument;
import org.apatrios.service.bike.argument.SearchBikeArgument;
import org.apatrios.service.bike.argument.UpdateBikeArgument;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.apatrios.controller.bike.internal.mapper.BikeMapper.BIKE_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/bike")
public class BikeInternalController {

    private final BikeService service;

    @PostMapping("create")
    public BikeDto create(@RequestBody CreateBikeDto dto) {
        CreateBikeArgument argument = BIKE_MAPPER.toCreateArgument(dto);

        return BIKE_MAPPER.toDto(service.create(argument));
    }

    @PutMapping("update/{id}")
    public BikeDto update(@RequestBody UpdateBikeDto dto, @PathVariable UUID id) {
        UpdateBikeArgument argument = BIKE_MAPPER.toUpdateArgument(dto);

        return BIKE_MAPPER.toDto(service.update(id, argument));
    }

    @GetMapping("list")
    public List<BikeDto> list(SearchBikeDto dto, Sort sort) {
        SearchBikeArgument searchArgument = BIKE_MAPPER.toSearchArgument(dto);

        return service.list(searchArgument, sort)
                      .stream()
                      .map(BIKE_MAPPER::toDto)
                      .toList();
    }
}
