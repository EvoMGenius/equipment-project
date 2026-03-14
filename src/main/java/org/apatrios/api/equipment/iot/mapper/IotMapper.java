package org.apatrios.api.equipment.iot.mapper;

import org.apatrios.action.equipment.iot.argument.CreateIotActionArgument;
import org.apatrios.api.equipment.iot.dto.CreateIotDto;
import org.apatrios.api.equipment.iot.dto.IotDto;
import org.apatrios.api.equipment.iot.dto.SearchIotDto;
import org.apatrios.model.equipment.Iot;
import org.apatrios.service.equipment.iot.argument.SearchIotArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IotMapper {
    IotMapper IOT_MAPPER = Mappers.getMapper(IotMapper.class);
    CreateIotActionArgument toCreateArgument(CreateIotDto dto);
    IotDto toDto(Iot iot);
    SearchIotArgument toSearchArgument(SearchIotDto dto);
}
