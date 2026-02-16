package org.apatrios.api.services.support.mapper;

import org.apatrios.api.services.support.dto.SupportDto;
import org.apatrios.api.services.support.dto.CreateSupportDto;
import org.apatrios.api.services.support.dto.SearchSupportDto;
import org.apatrios.action.services.support.create.CreateSupportActionArgument;
import org.apatrios.service.services.support.argument.SearchSupportArgument;
import org.apatrios.model.services.Support;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SupportMapper {
    SupportMapper SUPPORT_MAPPER = Mappers.getMapper(SupportMapper.class);

    SupportDto toDto(Support entity);
    CreateSupportActionArgument toCreateArgument(CreateSupportDto dto);
    SearchSupportArgument toSearchArgument(SearchSupportDto dto);
}