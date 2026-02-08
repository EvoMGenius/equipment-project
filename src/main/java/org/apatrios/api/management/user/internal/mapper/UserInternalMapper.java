package org.apatrios.api.management.user.internal.mapper;

import org.apatrios.action.management.user.change.email.approve.argument.ChangeEmailApproveActionArgument;
import org.apatrios.api.management.user.internal.dto.ChangeEmailApproveDto;
import org.apatrios.api.management.user.internal.dto.UserInternalDto;
import org.apatrios.model.management.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserInternalMapper {
    UserInternalDto toDto(User user);
    ChangeEmailApproveActionArgument toChangeEmailApproveArgument(ChangeEmailApproveDto dto);
}
