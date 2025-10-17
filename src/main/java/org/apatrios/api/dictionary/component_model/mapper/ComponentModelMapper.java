package org.apatrios.api.dictionary.component_model.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.component_model.dto.ComponentModelDto;
import org.apatrios.api.dictionary.component_model.dto.SearchComponentModelDto;
import org.apatrios.model.dictoinary.ComponentModel;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComponentModelMapper extends BaseDictionaryMapper<ComponentModel, ComponentModelDto, SearchComponentModelDto, BaseDictionarySearchArgument> {
}
