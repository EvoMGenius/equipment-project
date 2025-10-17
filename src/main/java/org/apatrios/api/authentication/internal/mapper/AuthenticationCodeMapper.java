package org.apatrios.api.authentication.internal.mapper;

import org.apatrios.action.authentication.create.argument.CreateAuthenticationCodeActionArgument;
import org.apatrios.api.authentication.internal.dto.CreateAuthenticationCodeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthenticationCodeMapper {
    CreateAuthenticationCodeActionArgument toCreateArgument(CreateAuthenticationCodeDto dto);
}
