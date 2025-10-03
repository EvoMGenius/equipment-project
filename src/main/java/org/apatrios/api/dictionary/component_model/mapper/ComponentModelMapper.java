package org.apatrios.api.dictionary.component_model.mapper;

import org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto;
import org.apatrios.api.dictionary.component_model.dto.ComponentModelDto;
import org.apatrios.model.dictoinary.ComponentModel;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper
public interface ComponentModelMapper {
    ComponentModelDto toDto(ComponentModel entity);
    BaseDictionarySearchArgument toSearchArgument(BaseDictionarySearchDto searchDto);
}
