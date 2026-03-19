package org.apatrios.action.management.user.profile.email.approve.argument;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ChangeEmailApproveActionArgument(UUID id, String email, String code) {
}
