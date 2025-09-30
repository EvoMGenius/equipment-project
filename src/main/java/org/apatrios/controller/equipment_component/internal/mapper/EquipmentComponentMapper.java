package org.apatrios.controller.equipment_component.internal.mapper;

import org.apatrios.action.equipment_component.create.CreateEquipmentComponentActionArgument;
import org.apatrios.action.equipment_component.update.UpdateEquipmentComponentActionArgument;
import org.apatrios.controller.equipment_component.internal.dto.EquipmentComponentDto;
import org.apatrios.controller.equipment_component.internal.dto.CreateEquipmentComponentDto;
import org.apatrios.controller.equipment_component.internal.dto.SearchEquipmentComponentDto;
import org.apatrios.controller.equipment_component.internal.dto.UpdateEquipmentComponentDto;
import org.apatrios.model.EquipmentComponent;
import org.apatrios.service.equipment_component.argument.SearchEquipmentComponentArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EquipmentComponentMapper {
    EquipmentComponentMapper COMPONENT_MAPPER = Mappers.getMapper(EquipmentComponentMapper.class);

    SearchEquipmentComponentArgument toSearchArgument(SearchEquipmentComponentDto dto);
    EquipmentComponentDto toDto(EquipmentComponent component);
    CreateEquipmentComponentActionArgument toCreateArgument(CreateEquipmentComponentDto dto);
    UpdateEquipmentComponentActionArgument toUpdateArgument(UpdateEquipmentComponentDto dto);
}