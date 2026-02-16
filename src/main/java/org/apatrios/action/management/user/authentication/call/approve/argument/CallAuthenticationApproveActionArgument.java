package org.apatrios.action.management.user.authentication.call.approve.argument;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CallAuthenticationApproveActionArgument {
    String phoneNumber;
    String code;
}
