package org.apatrios.action.management.user.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.user.update.argument.UpdateUserActionArgument;
import org.apatrios.model.management.Staff;
import org.apatrios.model.management.User;
import org.apatrios.service.management.staff.StaffService;
import org.apatrios.service.management.user.UserService;
import org.apatrios.service.management.user.argument.UpdateUserArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateUserAction implements Action<UpdateUserActionArgument, User> {

    StaffService staffService;
    UserService userService;

    @Override
    @Transactional
    public User execute(@NonNull UpdateUserActionArgument argument) {
        Staff staff = staffService.getExisting(argument.getStaffId());

        return userService.update(argument.getId(),
                                  UpdateUserArgument.builder()
                                                    .staff(staff)
                                                    .username(argument.getUsername())
                                                    .authorities(argument.getAuthorities())
                                                    .status(argument.getStatus())
                                                    .userProfile(argument.getUserProfile())
                                                    .build());
    }
}
