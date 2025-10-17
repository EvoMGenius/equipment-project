package org.apatrios.api.services.request.internal.mapper;

import org.apatrios.action.services.request.create.CreateRequestActionArgument;
import org.apatrios.action.services.request.update.UpdateRequestActionArgument;
import org.apatrios.api.services.request.internal.dto.CreateRequestDto;
import org.apatrios.api.services.request.internal.dto.RequestDto;
import org.apatrios.api.services.request.internal.dto.SearchRequestDto;
import org.apatrios.api.services.request.internal.dto.UpdateRequestDto;
import org.apatrios.model.services.Request;
import org.apatrios.service.services.request.argument.SearchRequestArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RequestMapper {
    RequestMapper REQUEST_MAPPER = Mappers.getMapper(RequestMapper.class);

    RequestDto toDto(Request request);
    CreateRequestActionArgument toCreateArgument(CreateRequestDto dto);
    UpdateRequestActionArgument toUpdateArgument(UpdateRequestDto dto);
    SearchRequestArgument toSearchArgument(SearchRequestDto dto);
}
