package org.apatrios.api.management.user.authentication.mapper;

import org.apatrios.action.management.user.authentication.call.approve.argument.CallAuthenticationApproveActionArgument;
import org.apatrios.action.management.user.authentication.create.argument.CreateUserActionArgument;
import org.apatrios.action.management.user.authentication.telegram.approve.argument.TelegramAuthenticationApproveActionArgument;
import org.apatrios.api.management.user.authentication.dto.CallAuthenticationApproveDto;
import org.apatrios.api.management.user.authentication.dto.CreateUserDto;
import org.apatrios.api.management.user.authentication.dto.TelegramAuthenticationApproveDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthenticationMapper {
    TelegramAuthenticationApproveActionArgument toTelegramApproveArgument(TelegramAuthenticationApproveDto dto);
    CallAuthenticationApproveActionArgument toCallApproveArgument(CallAuthenticationApproveDto dto);
    CreateUserActionArgument toCreateArgument(CreateUserDto dto);
}
