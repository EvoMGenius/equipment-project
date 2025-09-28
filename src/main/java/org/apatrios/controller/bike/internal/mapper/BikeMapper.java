package org.apatrios.controller.bike.internal.mapper;

import org.apatrios.action.bike.create.CreateBikeActionArgument;
import org.apatrios.action.bike.update.UpdateBikeActionArgument;
import org.apatrios.controller.bike.internal.dto.BikeDto;
import org.apatrios.controller.bike.internal.dto.CreateBikeDto;
import org.apatrios.controller.bike.internal.dto.SearchBikeDto;
import org.apatrios.controller.bike.internal.dto.UpdateBikeDto;
import org.apatrios.model.Bike;
import org.apatrios.service.bike.argument.SearchBikeArgument;
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
