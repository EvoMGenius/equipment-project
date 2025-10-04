package org.apatrios.action.management.user.password.argument;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class UpdatePasswordActionArgument {

    String password;

    UUID code;
}
