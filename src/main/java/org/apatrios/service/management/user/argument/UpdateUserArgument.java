package org.apatrios.service.management.user.argument;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateUserArgument {
    String email;

}
