package org.apatrios.api.management.user.authentication.mapper;

import org.apatrios.action.management.user.authentication.call.approve.argument.CallAuthenticationApproveActionArgument;
import org.apatrios.action.management.user.authentication.registration.argument.CompleteRegistrationUserActionArgument;
import org.apatrios.action.management.user.authentication.telegram.approve.argument.TelegramAuthenticationApproveActionArgument;
import org.apatrios.api.management.user.authentication.dto.CallAuthenticationApproveDto;
import org.apatrios.api.management.user.authentication.dto.CompleteRegistrationUserDto;
import org.apatrios.api.management.user.authentication.dto.TelegramAuthenticationApproveDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthenticationMapper {
    TelegramAuthenticationApproveActionArgument toTelegramApproveArgument(TelegramAuthenticationApproveDto dto);
    CallAuthenticationApproveActionArgument toCallApproveArgument(CallAuthenticationApproveDto dto);
    CompleteRegistrationUserActionArgument toCreateArgument(CompleteRegistrationUserDto dto);
}
