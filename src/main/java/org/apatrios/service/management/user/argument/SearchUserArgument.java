package org.apatrios.service.management.user.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.Role;
import org.apatrios.model.management.UserStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchUserArgument {
    String login;

    Role role;

    UUID staffId;

    UserStatus status;

    LocalDateTime lastLoginFrom;

    LocalDateTime lastLoginTo;

    LocalDateTime createDateFrom;

    LocalDateTime createDateTo;

    LocalDateTime updateDateFrom;

    LocalDateTime updateDateTo;

    boolean isDeleted;
}
