package org.apatrios.service.management.user.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.UserStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class SearchUserArgument {
    String username;

    Set<String> authorities;

    UUID staffId;

    UserStatus status;

    LocalDateTime lastLoginFrom;

    LocalDateTime lastLoginTo;

    LocalDateTime createDateFrom;

    LocalDateTime createDateTo;

    LocalDateTime updateDateFrom;

    LocalDateTime updateDateTo;

    boolean enabled;

    String lastName;

    String firstName;

    String middleName;
}
