package org.apatrios.action.management.user.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.management.Staff;
import org.apatrios.model.management.User;
import org.apatrios.service.management.staff.StaffService;
import org.apatrios.service.management.user.UserService;
import org.apatrios.service.management.user.argument.CreateUserArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateUserAction implements Action<CreateUserActionArgument, User> {

    StaffService staffService;
    UserService userService;

    @Override
    @Transactional
    public User execute(@NonNull CreateUserActionArgument argument) {
        Staff staff = staffService.getExisting(argument.getStaffId());
        return userService.create(CreateUserArgument.builder()
                                                    .staff(staff)
                                                    .login(argument.getLogin())
                                                    .role(argument.getRole())
                                                    .build());
    }
}
