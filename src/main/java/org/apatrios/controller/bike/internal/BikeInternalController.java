package org.apatrios.controller.bike.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.bike.create.CreateBikeActionArgument;
import org.apatrios.action.bike.update.UpdateBikeActionArgument;
import org.apatrios.controller.bike.internal.dto.BikeDto;
import org.apatrios.controller.bike.internal.dto.CreateBikeDto;
import org.apatrios.controller.bike.internal.dto.SearchBikeDto;
import org.apatrios.controller.bike.internal.dto.UpdateBikeDto;
import org.apatrios.model.Bike;
import org.apatrios.service.bike.BikeService;
import org.apatrios.service.bike.argument.SearchBikeArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.controller.bike.internal.mapper.BikeMapper.BIKE_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/bike")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BikeInternalController {

    Action<CreateBikeActionArgument, Bike> createBikeAction;
    Action<UpdateBikeActionArgument, Bike> updateBikeAction;
    BikeService service;

    @PostMapping("create")
    public BikeDto create(@Valid @RequestBody CreateBikeDto dto) {
        return BIKE_MAPPER.toDto(createBikeAction.execute(BIKE_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public BikeDto update(@Valid @RequestBody UpdateBikeDto dto) {
        return BIKE_MAPPER.toDto(updateBikeAction.execute(BIKE_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("list")
    public List<BikeDto> list(SearchBikeDto dto, Sort sort) {
        SearchBikeArgument searchArgument = BIKE_MAPPER.toSearchArgument(dto);

        return service.list(searchArgument, sort)
                      .stream()
                      .map(BIKE_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<BikeDto> page(SearchBikeDto dto, Pageable pageable) {
        SearchBikeArgument searchArgument = BIKE_MAPPER.toSearchArgument(dto);

        Page<BikeDto> dtoPage = service.page(searchArgument, pageable)
                                       .map(BIKE_MAPPER::toDto);

        return CollectionDto.of(dtoPage);
    }

    @DeleteMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
