package org.apatrios.controller.bike.internal.mapper;

import org.apatrios.controller.bike.internal.dto.BikeDto;
import org.apatrios.controller.bike.internal.dto.CreateBikeDto;
import org.apatrios.controller.bike.internal.dto.SearchBikeDto;
import org.apatrios.controller.bike.internal.dto.UpdateBikeDto;
import org.apatrios.model.Bike;
import org.apatrios.service.bike.argument.CreateBikeArgument;
import org.apatrios.service.bike.argument.SearchBikeArgument;
import org.apatrios.service.bike.argument.UpdateBikeArgument;
import org.mapstruct.factory.Mappers;

public interface BikeMapper {
    BikeMapper BIKE_MAPPER = Mappers.getMapper(BikeMapper.class);

    SearchBikeArgument toSearchArgument(SearchBikeDto dto);

    BikeDto toDto(Bike bike);

    CreateBikeArgument toCreateArgument(CreateBikeDto dto);

    UpdateBikeArgument toUpdateArgument(UpdateBikeDto dto);
}
