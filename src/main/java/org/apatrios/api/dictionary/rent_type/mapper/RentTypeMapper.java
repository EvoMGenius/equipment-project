package org.apatrios.api.dictionary.rent_type.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.rent_type.dto.RentTypeDto;
import org.apatrios.api.dictionary.rent_type.dto.SearchRentTypeDto;
import org.apatrios.model.dictoinary.RentType;
import org.apatrios.service.dictionary.argument.SearchRentTypeArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentTypeMapper extends BaseDictionaryMapper<RentType, RentTypeDto, SearchRentTypeDto, SearchRentTypeArgument> {
}
