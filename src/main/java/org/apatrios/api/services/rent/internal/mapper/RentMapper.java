package org.apatrios.api.services.rent.internal.mapper;

import org.apatrios.action.services.rent.create.CreateRentActionArgument;
import org.apatrios.action.services.rent.update.UpdateRentActionArgument;
import org.apatrios.api.services.rent.internal.dto.CreateRentDto;
import org.apatrios.api.services.rent.internal.dto.RentDto;
import org.apatrios.api.services.rent.internal.dto.SearchRentDto;
import org.apatrios.api.services.rent.internal.dto.UpdateRentDto;
import org.apatrios.model.services.Rent;
import org.apatrios.service.services.rent.argument.SearchRentArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentMapper {
    RentMapper RENT_MAPPER = Mappers.getMapper(RentMapper.class);

    RentDto toDto(Rent rent);
    CreateRentActionArgument toCreateArgument(CreateRentDto dto);
    UpdateRentActionArgument toUpdateArgument(UpdateRentDto dto);
    SearchRentArgument toSearchArgument(SearchRentDto dto);
}
