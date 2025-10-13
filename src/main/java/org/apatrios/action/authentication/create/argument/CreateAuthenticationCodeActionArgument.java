package org.apatrios.action.authentication.create.argument;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateAuthenticationCodeActionArgument {
    String username;
    String password;
}
