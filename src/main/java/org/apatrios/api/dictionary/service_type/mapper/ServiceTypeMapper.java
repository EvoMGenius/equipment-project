package org.apatrios.api.dictionary.service_type.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.service_type.dto.SearchServiceTypeDto;
import org.apatrios.api.dictionary.service_type.dto.ServiceTypeDto;
import org.apatrios.model.dictoinary.ServiceType;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceTypeMapper extends BaseDictionaryMapper<ServiceType, ServiceTypeDto, SearchServiceTypeDto, BaseDictionarySearchArgument> {
}
