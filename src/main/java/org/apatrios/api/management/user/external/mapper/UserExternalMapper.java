package org.apatrios.api.management.user.external.mapper;

import org.apatrios.action.management.user.authentication.AuthenticationUserActionArgument;
import org.apatrios.action.management.user.create.CreateUserActionArgument;
import org.apatrios.action.management.user.password.argument.UpdatePasswordActionArgument;
import org.apatrios.api.management.user.external.dto.AuthenticationUserExternalDto;
import org.apatrios.api.management.user.external.dto.CreateUserExternalDto;
import org.apatrios.api.management.user.external.dto.UpdatePasswordByCodeExternalDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserExternalMapper {
    UpdatePasswordActionArgument toUpdatePasswordArgument(UpdatePasswordByCodeExternalDto dto);

    CreateUserActionArgument toCreateArgument(CreateUserExternalDto dto);

    AuthenticationUserActionArgument toAuthenticationArgument(AuthenticationUserExternalDto dto);
}
