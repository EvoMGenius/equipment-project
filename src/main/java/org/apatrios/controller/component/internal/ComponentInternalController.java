package org.apatrios.controller.component.internal;

import lombok.RequiredArgsConstructor;
import org.apatrios.controller.component.internal.dto.ComponentDto;
import org.apatrios.controller.component.internal.dto.CreateComponentDto;
import org.apatrios.controller.component.internal.dto.SearchComponentDto;
import org.apatrios.controller.component.internal.dto.UpdateComponentDto;
import org.apatrios.service.component.ComponentService;
import org.apatrios.service.component.argument.CreateComponentArgument;
import org.apatrios.service.component.argument.SearchComponentArgument;
import org.apatrios.service.component.argument.UpdateComponentArgument;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.apatrios.controller.component.internal.mapper.ComponentMapper.COMPONENT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/component")
public class ComponentInternalController {

    private final ComponentService service;

    @PostMapping("create")
    public ComponentDto create(@RequestBody CreateComponentDto dto) {
        CreateComponentArgument argument = COMPONENT_MAPPER.toCreateArgument(dto);
        return COMPONENT_MAPPER.toDto(service.create(argument));
    }

    @PutMapping("update/{id}")
    public ComponentDto update(@RequestBody UpdateComponentDto dto, @PathVariable UUID id) {
        UpdateComponentArgument argument = COMPONENT_MAPPER.toUpdateArgument(dto);
        return COMPONENT_MAPPER.toDto(service.update(id, argument));
    }

    @GetMapping("list")
    public List<ComponentDto> list(SearchComponentDto dto, Sort sort) {
        SearchComponentArgument searchArgument = COMPONENT_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(COMPONENT_MAPPER::toDto)
                      .toList();
    }
}