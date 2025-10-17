package org.apatrios.api.equipment.iot.internal.mapper;

import org.apatrios.action.equipment.iot.create.CreateIotActionArgument;
import org.apatrios.action.equipment.iot.update.UpdateIotActionArgument;
import org.apatrios.api.equipment.iot.internal.dto.IotDto;
import org.apatrios.api.equipment.iot.internal.dto.CreateIotDto;
import org.apatrios.api.equipment.iot.internal.dto.SearchIotDto;
import org.apatrios.api.equipment.iot.internal.dto.UpdateIotDto;
import org.apatrios.model.equipment.Iot;
import org.apatrios.service.equipment.iot.argument.SearchIotArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IotMapper {
    IotMapper IOT_MAPPER = Mappers.getMapper(IotMapper.class);

    SearchIotArgument toSearchArgument(SearchIotDto dto);
    IotDto toDto(Iot iot);
    CreateIotActionArgument toCreateArgument(CreateIotDto dto);
    UpdateIotActionArgument toUpdateArgument(UpdateIotDto dto);
}