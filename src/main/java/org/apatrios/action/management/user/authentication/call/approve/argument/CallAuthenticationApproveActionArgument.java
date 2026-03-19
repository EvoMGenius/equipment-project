package org.apatrios.action.management.user.authentication.call.approve.argument;

import lombok.Builder;

@Builder
public record CallAuthenticationApproveActionArgument(String phoneNumber, String code) {
}
