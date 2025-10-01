package org.apatrios.service.management.user.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.Role;
import org.apatrios.model.management.Staff;
import org.apatrios.model.management.UserStatus;

@Value
@Builder
public class UpdateUserArgument {
    String login;

    Role role;

    Staff staff;

    UserStatus status;
}
