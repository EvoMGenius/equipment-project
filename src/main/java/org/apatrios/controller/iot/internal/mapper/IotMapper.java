package org.apatrios.controller.iot.internal.mapper;

import org.apatrios.controller.iot.internal.dto.IotDto;
import org.apatrios.controller.iot.internal.dto.CreateIotDto;
import org.apatrios.controller.iot.internal.dto.SearchIotDto;
import org.apatrios.controller.iot.internal.dto.UpdateIotDto;
import org.apatrios.model.Iot;
import org.apatrios.service.iot.argument.CreateIotArgument;
import org.apatrios.service.iot.argument.SearchIotArgument;
import org.apatrios.service.iot.argument.UpdateIotArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IotMapper {
    IotMapper IOT_MAPPER = Mappers.getMapper(IotMapper.class);

    SearchIotArgument toSearchArgument(SearchIotDto dto);
    IotDto toDto(Iot iot);
    CreateIotArgument toCreateArgument(CreateIotDto dto);
    UpdateIotArgument toUpdateArgument(UpdateIotDto dto);
}