package org.apatrios.api.services.rent_compose.internal.mapper;

import org.apatrios.action.services.rent_compose.create.CreateRentComposeActionArgument;
import org.apatrios.action.services.rent_compose.update.UpdateRentComposeActionArgument;
import org.apatrios.api.services.rent_compose.internal.dto.CreateRentComposeDto;
import org.apatrios.api.services.rent_compose.internal.dto.RentComposeDto;
import org.apatrios.api.services.rent_compose.internal.dto.SearchRentComposeDto;
import org.apatrios.api.services.rent_compose.internal.dto.UpdateRentComposeDto;
import org.apatrios.model.services.RentCompose;
import org.apatrios.service.services.rent_compose.argument.SearchRentComposeArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentComposeMapper {
    RentComposeMapper RENT_COMPOSE_MAPPER = Mappers.getMapper(RentComposeMapper.class);

    RentComposeDto toDto(RentCompose rentCompose);
    CreateRentComposeActionArgument toCreateArgument(CreateRentComposeDto dto);
    UpdateRentComposeActionArgument toUpdateArgument(UpdateRentComposeDto dto);
    SearchRentComposeArgument toSearchArgument(SearchRentComposeDto dto);
}
