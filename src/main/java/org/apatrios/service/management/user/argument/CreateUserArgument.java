package org.apatrios.service.management.user.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.Role;
import org.apatrios.model.management.Staff;

@Value
@Builder
public class CreateUserArgument {
    String login;

    Role role;

    Staff staff;
}
