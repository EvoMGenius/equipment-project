package org.apatrios.action.management.user.authentication.registration.argument;

import lombok.Builder;
import org.apatrios.model.management.UserProfile;

import java.util.UUID;

@Builder
public record CompleteRegistrationUserActionArgument(
        UUID id,
        UserProfile userProfile
) {
}
