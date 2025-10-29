package org.apatrios.action.management.user.create;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.UserProfile;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateUserActionArgument {
    String username;
    String password;
    UserProfile userProfile;
    Set<UUID> franchiseeIds;
}
