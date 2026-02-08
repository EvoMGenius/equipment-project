package org.apatrios.action.management.user.change.email.approve.argument;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ChangeEmailApproveActionArgument {
    UUID id;
    String email;
    String code;
}
