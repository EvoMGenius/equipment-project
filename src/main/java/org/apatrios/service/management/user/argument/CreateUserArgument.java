package org.apatrios.service.management.user.argument;

import lombok.Builder;
import org.apatrios.model.management.UserProfile;
import org.apatrios.model.services.Photo;

import java.util.Set;

@Builder
public record CreateUserArgument(
        UserProfile userProfile,
        String email,
        String phoneNumber,
        Photo avatar,
        Set<String> authorities
) {
}
