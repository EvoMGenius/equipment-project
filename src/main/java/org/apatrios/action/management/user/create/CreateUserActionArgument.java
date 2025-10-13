package org.apatrios.action.management.user.create;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.UserProfile;

@Value
@Builder
public class CreateUserActionArgument {
    String username;

    String password;

    UserProfile userProfile;
}
