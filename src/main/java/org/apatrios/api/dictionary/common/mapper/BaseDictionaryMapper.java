package org.apatrios.api.dictionary.common.mapper;

import org.apatrios.api.dictionary.common.dto.BaseDictionaryDto;
import org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto;
import org.apatrios.model.dictoinary.BaseDictionary;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;

public interface BaseDictionaryMapper<T extends BaseDictionary,
        DictionaryDtoT extends BaseDictionaryDto,
        SearchDto extends BaseDictionarySearchDto,
        SearchArg extends BaseDictionarySearchArgument> {

    DictionaryDtoT toDto(T entity);

    SearchArg toSearchArgument(SearchDto searchDto);
}
