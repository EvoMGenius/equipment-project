package org.apatrios.controller.dictionary.mapper;

import org.apatrios.model.dictoinary.BaseDictionary;
import org.apatrios.controller.dictionary.dto.DictionaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DictionaryMapper {

//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "createDate", ignore = true)
//    BaseDictionary toEntity(DictionaryDto dto);
//
//    DictionaryDto toDto(BaseDictionary entity);
}
