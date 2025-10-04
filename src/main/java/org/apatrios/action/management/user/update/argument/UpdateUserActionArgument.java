package org.apatrios.action.management.user.update.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.UserProfile;
import org.apatrios.model.management.UserStatus;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class UpdateUserActionArgument {
    UUID id;

    String username;

    Set<String> authorities;

    UUID staffId;

    UserProfile userProfile;

    UserStatus status;
}
