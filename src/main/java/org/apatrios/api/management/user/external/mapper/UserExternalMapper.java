package org.apatrios.api.management.user.external.mapper;

import org.apatrios.action.management.user.authentication.call.approve.argument.CallAuthenticationApproveActionArgument;
import org.apatrios.action.management.user.authentication.create.argument.CreateUserActionArgument;
import org.apatrios.action.management.user.authentication.telegram.approve.argument.TelegramAuthenticationApproveActionArgument;
import org.apatrios.api.management.user.external.dto.CallAuthenticationApproveDto;
import org.apatrios.api.management.user.external.dto.CreateUserDto;
import org.apatrios.api.management.user.external.dto.TelegramAuthenticationApproveDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserExternalMapper {
    TelegramAuthenticationApproveActionArgument toTelegramApproveArgument(TelegramAuthenticationApproveDto dto);
    CallAuthenticationApproveActionArgument toCallApproveArgument(CallAuthenticationApproveDto dto);
    CreateUserActionArgument toCreateArgument(CreateUserDto dto);
}
