package org.apatrios.api.management.user.profile.mapper;

import org.apatrios.action.management.user.profile.email.approve.argument.ChangeEmailApproveActionArgument;
import org.apatrios.api.management.user.profile.dto.ChangeEmailApproveDto;
import org.apatrios.api.management.user.profile.dto.UserProfileDto;
import org.apatrios.model.management.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProfileMapper {
    UserProfileDto toDto(User user);
    ChangeEmailApproveActionArgument toChangeEmailApproveArgument(ChangeEmailApproveDto dto);
}
