package org.apatrios.action.management.user.authentication.telegram.approve.argument;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TelegramAuthenticationApproveActionArgument {
    String login;
    String code;
}
