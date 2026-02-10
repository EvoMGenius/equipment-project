package org.apatrios.action.management.user.authentication.create.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.UserProfile;

@Value
@Builder
public class CreateUserActionArgument {
    UserProfile userProfile;
    String login;
}
