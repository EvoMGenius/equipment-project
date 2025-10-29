package org.apatrios.api.management.management_point.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.management_point.create.CreateManagementPointActionArgument;
import org.apatrios.action.management.management_point.update.UpdateManagementPointActionArgument;
import org.apatrios.api.management.management_point.internal.dto.CreateManagementPointDto;
import org.apatrios.api.management.management_point.internal.dto.ManagementPointDto;
import org.apatrios.api.management.management_point.internal.dto.SearchManagementPointDto;
import org.apatrios.api.management.management_point.internal.dto.UpdateManagementPointDto;
import org.apatrios.model.management.ManagementPoint;
import org.apatrios.service.management.management_point.ManagementPointService;
import org.apatrios.service.management.management_point.argument.SearchManagementPointArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.management.management_point.internal.mapper.ManagementPointMapper.POINT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/point")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ManagementPointController {

    ManagementPointService service;
    Action<CreateManagementPointActionArgument, ManagementPoint> createPointAction;
    Action<UpdateManagementPointActionArgument, ManagementPoint> updatePointAction;

    @PostMapping("create")
    public ManagementPointDto create(@Valid @RequestBody CreateManagementPointDto dto) {
        return POINT_MAPPER.toDto(createPointAction.execute(POINT_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public ManagementPointDto update(@Valid @RequestBody UpdateManagementPointDto dto) {
        return POINT_MAPPER.toDto(updatePointAction.execute(POINT_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("{id}")
    public ManagementPointDto get(@PathVariable UUID id) {
        return POINT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("list")
    public List<ManagementPointDto> list(SearchManagementPointDto dto, Sort sort) {
        SearchManagementPointArgument argument = POINT_MAPPER.toSearchArgument(dto);

        return service.list(argument, sort)
                      .stream()
                      .map(POINT_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<ManagementPointDto> page(SearchManagementPointDto dto, Pageable pageable) {
        SearchManagementPointArgument argument = POINT_MAPPER.toSearchArgument(dto);

        return CollectionDto.of(service.page(argument, pageable)
                                       .map(POINT_MAPPER::toDto));
    }

    @PostMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
