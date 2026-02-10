package org.apatrios.api.management.management_point.internal.mapper;

import org.apatrios.action.management.management_point.create.CreateManagementPointActionArgument;
import org.apatrios.api.management.management_point.internal.dto.CreateManagementPointDto;
import org.apatrios.api.management.management_point.internal.dto.ManagementPointDto;
import org.apatrios.api.management.management_point.internal.dto.SearchManagementPointDto;
import org.apatrios.model.management.ManagementPoint;
import org.apatrios.service.management.management_point.argument.SearchManagementPointArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ManagementPointMapper {
    ManagementPointMapper POINT_MAPPER = Mappers.getMapper(ManagementPointMapper.class);

    CreateManagementPointActionArgument toCreateArgument(CreateManagementPointDto dto);
    SearchManagementPointArgument toSearchArgument(SearchManagementPointDto dto);
    ManagementPointDto toDto(ManagementPoint point);
}
