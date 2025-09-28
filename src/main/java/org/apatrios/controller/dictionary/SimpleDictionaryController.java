package org.apatrios.controller.dictionary;

import org.apatrios.controller.dictionary.dto.BaseDictionarySearchDto;
import org.apatrios.model.dictoinary.BaseDictionary;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;

import static org.apatrios.controller.dictionary.mapper.DictionaryMapper.DICTIONARY_MAPPER;

public abstract class SimpleDictionaryController<T extends BaseDictionary>
        extends BaseDictionaryController<T, BaseDictionarySearchArgument, BaseDictionarySearchDto> {

    @Override
    protected BaseDictionarySearchArgument toSearch(BaseDictionarySearchDto dto) {
        return DICTIONARY_MAPPER.toArgument(dto);
    }
}
