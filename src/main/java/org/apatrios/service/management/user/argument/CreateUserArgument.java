package org.apatrios.service.management.user.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.UserProfile;

import java.util.Set;

@Value
@Builder
public class CreateUserArgument {
    String username;

    String password;

    Set<String> authorities;

    UserProfile userProfile;
}
