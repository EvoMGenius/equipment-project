package org.apatrios.api.equipment.bike.internal.mapper;

import org.apatrios.action.equipment.bike.create.CreateBikeActionArgument;
import org.apatrios.action.equipment.bike.update.UpdateBikeActionArgument;
import org.apatrios.api.equipment.bike.internal.dto.BikeDto;
import org.apatrios.api.equipment.bike.internal.dto.CreateBikeDto;
import org.apatrios.api.equipment.bike.internal.dto.SearchBikeDto;
import org.apatrios.api.equipment.bike.internal.dto.UpdateBikeDto;
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

    UpdateBikeActionArgument toUpdateArgument(UpdateBikeDto dto);
}
