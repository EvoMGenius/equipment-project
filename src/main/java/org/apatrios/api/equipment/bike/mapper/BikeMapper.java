package org.apatrios.api.equipment.bike.mapper;

import org.apatrios.action.equipment.bike.create.CreateBikeActionArgument;
import org.apatrios.api.equipment.bike.dto.BikeDto;
import org.apatrios.api.equipment.bike.dto.CreateBikeDto;
import org.apatrios.api.equipment.bike.dto.SearchBikeDto;
import org.apatrios.model.equipment.Bike;
import org.apatrios.service.equipment.bike.argument.SearchBikeArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BikeMapper {
    BikeMapper BIKE_MAPPER = Mappers.getMapper(BikeMapper.class);

    SearchBikeArgument toSearchArgument(SearchBikeDto dto);

    BikeDto toDto(Bike bike);

    CreateBikeActionArgument toCreateArgument(CreateBikeDto dto);
}
