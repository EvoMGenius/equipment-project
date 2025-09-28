package org.apatrios.controller.component.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.component.create.CreateComponentAction;
import org.apatrios.action.component.update.UpdateComponentAction;
import org.apatrios.controller.component.internal.dto.ComponentDto;
import org.apatrios.controller.component.internal.dto.CreateComponentDto;
import org.apatrios.controller.component.internal.dto.SearchComponentDto;
import org.apatrios.controller.component.internal.dto.UpdateComponentDto;
import org.apatrios.service.component.ComponentService;
import org.apatrios.service.component.argument.SearchComponentArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.controller.component.internal.mapper.ComponentMapper.COMPONENT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/component")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ComponentInternalController {

    ComponentService service;
    CreateComponentAction createComponentAction;
    UpdateComponentAction updateComponentAction;

    @PostMapping("create")
    public ComponentDto create(@Valid @RequestBody CreateComponentDto dto) {
        return COMPONENT_MAPPER.toDto(createComponentAction.execute(COMPONENT_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public ComponentDto update(@Valid @RequestBody UpdateComponentDto dto) {
        return COMPONENT_MAPPER.toDto(updateComponentAction.execute(COMPONENT_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("list")
    public List<ComponentDto> list(SearchComponentDto dto, Sort sort) {
        SearchComponentArgument searchArgument = COMPONENT_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(COMPONENT_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<ComponentDto> page(SearchComponentDto dto, Pageable pageable) {
        SearchComponentArgument searchArgument = COMPONENT_MAPPER.toSearchArgument(dto);

        Page<ComponentDto> dtoPage = service.page(searchArgument, pageable)
                                            .map(COMPONENT_MAPPER::toDto);

        return CollectionDto.of(dtoPage);
    }

    @DeleteMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}