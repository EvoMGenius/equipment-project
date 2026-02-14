package org.apatrios.api.equipment.status.mapper;

import org.apatrios.api.equipment.status.dto.CreateStatusDto;
import org.apatrios.api.equipment.status.dto.SearchStatusDto;
import org.apatrios.api.equipment.status.dto.StatusDto;
import org.apatrios.model.equipment.Status;
import org.apatrios.service.equipment.status.argument.CreateStatusArgument;
import org.apatrios.service.equipment.status.argument.SearchStatusArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StatusMapper {
    StatusMapper STATUS_MAPPER = Mappers.getMapper(StatusMapper.class);

    SearchStatusArgument toSearchArgument(SearchStatusDto dto);
    StatusDto toDto(Status status);
    CreateStatusArgument toCreateArgument(CreateStatusDto dto);
}
