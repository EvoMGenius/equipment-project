package org.apatrios.controller.component.internal.mapper;

import org.apatrios.action.component.create.CreateComponentActionArgument;
import org.apatrios.action.component.update.UpdateComponentActionArgument;
import org.apatrios.controller.component.internal.dto.ComponentDto;
import org.apatrios.controller.component.internal.dto.CreateComponentDto;
import org.apatrios.controller.component.internal.dto.SearchComponentDto;
import org.apatrios.controller.component.internal.dto.UpdateComponentDto;
import org.apatrios.model.Component;
import org.apatrios.service.component.argument.SearchComponentArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComponentMapper {
    ComponentMapper COMPONENT_MAPPER = Mappers.getMapper(ComponentMapper.class);

    SearchComponentArgument toSearchArgument(SearchComponentDto dto);
    ComponentDto toDto(Component component);
    CreateComponentActionArgument toCreateArgument(CreateComponentDto dto);
    UpdateComponentActionArgument toUpdateArgument(UpdateComponentDto dto);
}