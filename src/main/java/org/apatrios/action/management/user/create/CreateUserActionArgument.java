package org.apatrios.action.management.user.create;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.Role;

import java.util.UUID;

@Value
@Builder
public class CreateUserActionArgument {
    String login;

    Role role;

    UUID staffId;
}
