package org.apatrios.api.management.user.internal.mapper;

import org.apatrios.action.management.user.update.argument.UpdateUserActionArgument;
import org.apatrios.api.management.user.internal.dto.SearchUserInternalDto;
import org.apatrios.api.management.user.internal.dto.UpdateUserInternalDto;
import org.apatrios.api.management.user.internal.dto.UserInternalDto;
import org.apatrios.model.management.User;
import org.apatrios.service.management.user.argument.SearchUserArgument;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserInternalMapper {
    UserInternalDto toDto(User user);
    SearchUserArgument toSearchArgument(SearchUserInternalDto dto);
    UpdateUserActionArgument toUpdateArgument(UpdateUserInternalDto dto);
}
