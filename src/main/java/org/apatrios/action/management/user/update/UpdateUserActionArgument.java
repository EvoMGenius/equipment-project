package org.apatrios.action.management.user.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.Role;
import org.apatrios.model.management.UserStatus;

import java.util.UUID;

@Value
@Builder
public class UpdateUserActionArgument {
    UUID id;

    String login;

    Role role;

    UUID staffId;

    UserStatus status;
}
