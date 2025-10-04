package org.apatrios.api.dictionary.point.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.point.dto.PointDto;
import org.apatrios.api.dictionary.point.dto.SearchPointDto;
import org.apatrios.model.dictoinary.Point;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PointMapper extends BaseDictionaryMapper<Point, PointDto, SearchPointDto, BaseDictionarySearchArgument> {
}
