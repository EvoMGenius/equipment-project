package org.apatrios.action.management.user.authentication;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthenticationUserActionArgument {
    String username;

    String password;
}
