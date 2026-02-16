package org.apatrios.api.dictionary.dict.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.dict.dto.DictDto;
import org.apatrios.api.dictionary.dict.dto.SearchDictDto;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.service.dictionary.argument.SearchDictArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DictMapper extends BaseDictionaryMapper<Dict, DictDto, SearchDictDto, SearchDictArgument> {
}
