package org.apatrios.action.management.user.authentication.telegram.approve.argument;

import lombok.Builder;

@Builder
public record TelegramAuthenticationApproveActionArgument(String phoneNumber, String code) {
}
