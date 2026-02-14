package org.apatrios.api.management.point.mapper;

import org.apatrios.action.management.point.create.CreatePointActionArgument;
import org.apatrios.api.management.point.dto.CreatePointDto;
import org.apatrios.api.management.point.dto.PointDto;
import org.apatrios.api.management.point.dto.SearchPointDto;
import org.apatrios.model.management.Point;
import org.apatrios.service.management.point.argument.SearchPointArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PointMapper {
    PointMapper POINT_MAPPER = Mappers.getMapper(PointMapper.class);

    CreatePointActionArgument toCreateArgument(CreatePointDto dto);
    SearchPointArgument toSearchArgument(SearchPointDto dto);
    PointDto toDto(Point point);
}
