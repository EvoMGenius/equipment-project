package org.apatrios.action.management.user.password.argument;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdatePasswordActionArgument {

    String password;

    String code;
}
