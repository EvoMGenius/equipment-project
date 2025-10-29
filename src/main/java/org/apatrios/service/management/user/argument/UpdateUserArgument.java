package org.apatrios.service.management.user.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.UserProfile;
import org.apatrios.model.management.UserStatus;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class UpdateUserArgument {
    String username;
    Set<String> authorities;
    UserProfile userProfile;
    UserStatus status;
    Set<UUID> franchiseeIds;
}
