package org.apatrios.api.dictionary.service_dictionary.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.service_dictionary.dto.SearchServiceDictionaryDto;
import org.apatrios.api.dictionary.service_dictionary.dto.ServiceDictionaryDto;
import org.apatrios.model.dictoinary.ServiceDictionary;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceDictionaryMapper extends BaseDictionaryMapper<ServiceDictionary, ServiceDictionaryDto, SearchServiceDictionaryDto, BaseDictionarySearchArgument> {
}
