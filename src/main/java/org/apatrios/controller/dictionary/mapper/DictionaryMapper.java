package org.apatrios.controller.dictionary.mapper;

import org.apatrios.controller.dictionary.dto.BaseDictionarySearchDto;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DictionaryMapper {
    DictionaryMapper DICTIONARY_MAPPER = Mappers.getMapper(DictionaryMapper.class);

    BaseDictionarySearchArgument toArgument(BaseDictionarySearchDto dto);
}
