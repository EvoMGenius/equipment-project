package org.apatrios.api.equipment.equipment_component.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.equipment.equipment_component.create.CreateEquipmentComponentActionArgument;
import org.apatrios.action.equipment.equipment_component.update.UpdateEquipmentComponentActionArgument;
import org.apatrios.api.equipment.equipment_component.internal.dto.CreateEquipmentComponentDto;
import org.apatrios.api.equipment.equipment_component.internal.dto.EquipmentComponentDto;
import org.apatrios.api.equipment.equipment_component.internal.dto.SearchEquipmentComponentDto;
import org.apatrios.api.equipment.equipment_component.internal.dto.UpdateEquipmentComponentDto;
import org.apatrios.model.equipment.EquipmentComponent;
import org.apatrios.service.equipment.equipment_component.EquipmentComponentService;
import org.apatrios.service.equipment.equipment_component.argument.SearchEquipmentComponentArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.equipment.equipment_component.internal.mapper.EquipmentComponentMapper.COMPONENT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/component")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EquipmentComponentInternalController {

    EquipmentComponentService service;
    Action<CreateEquipmentComponentActionArgument, EquipmentComponent> createComponentAction;
    Action<UpdateEquipmentComponentActionArgument, EquipmentComponent> updateComponentAction;

    @PostMapping("create")
    public EquipmentComponentDto create(@Valid @RequestBody CreateEquipmentComponentDto dto) {
        return COMPONENT_MAPPER.toDto(createComponentAction.execute(COMPONENT_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public EquipmentComponentDto update(@Valid @RequestBody UpdateEquipmentComponentDto dto) {
        return COMPONENT_MAPPER.toDto(updateComponentAction.execute(COMPONENT_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("list")
    public List<EquipmentComponentDto> list(SearchEquipmentComponentDto dto, Sort sort) {
        SearchEquipmentComponentArgument searchArgument = COMPONENT_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(COMPONENT_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<EquipmentComponentDto> page(SearchEquipmentComponentDto dto, Pageable pageable) {
        SearchEquipmentComponentArgument searchArgument = COMPONENT_MAPPER.toSearchArgument(dto);

        Page<EquipmentComponentDto> dtoPage = service.page(searchArgument, pageable)
                                                     .map(COMPONENT_MAPPER::toDto);

        return CollectionDto.of(dtoPage);
    }

    @DeleteMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}