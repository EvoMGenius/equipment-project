package org.apatrios.api.dictionary.point_type.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.point_type.dto.PointTypeDto;
import org.apatrios.api.dictionary.point_type.dto.SearchPointTypeDto;
import org.apatrios.model.dictoinary.PointType;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PointTypeMapper extends BaseDictionaryMapper<PointType, PointTypeDto, SearchPointTypeDto, BaseDictionarySearchArgument> {
}
