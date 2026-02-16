package org.apatrios.service.management.user.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.UserProfile;
import org.apatrios.model.services.Photo;

@Value
@Builder
public class UpdateUserArgument {
    UserProfile userProfile;
    String email;
    String phoneNumber;
    Photo avatar;
    Boolean isEmailVerified;
    Boolean isDocVerified;
}
