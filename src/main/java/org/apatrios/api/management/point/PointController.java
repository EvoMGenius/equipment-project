package org.apatrios.api.management.point;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.point.create.CreatePointActionArgument;
import org.apatrios.api.management.point.dto.CreatePointDto;
import org.apatrios.api.management.point.dto.PointDto;
import org.apatrios.api.management.point.dto.SearchPointDto;
import org.apatrios.model.management.Point;
import org.apatrios.service.management.point.PointService;
import org.apatrios.service.management.point.argument.SearchPointArgument;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.management.point.mapper.PointMapper.POINT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management/point")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PointController {

    PointService service;
    Action<CreatePointActionArgument, Point> createPointAction;

    @PostMapping
    public PointDto create(@Valid @RequestBody CreatePointDto dto) {
        return POINT_MAPPER.toDto(createPointAction.execute(POINT_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public PointDto get(@PathVariable UUID id) {
        return POINT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public List<PointDto> list(SearchPointDto dto, Sort sort) {
        SearchPointArgument argument = POINT_MAPPER.toSearchArgument(dto);

        return service.list(argument, sort)
                      .stream()
                      .map(POINT_MAPPER::toDto)
                      .toList();
    }
}
