package org.apatrios.api.management.user.profile.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.UserProfile;
import org.apatrios.model.services.Photo;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "ДТО юзера")
public class UserProfileDto {

    UserProfile userProfile;

    String email;

    String phoneNumber;

    String password;

    LocalDateTime createDate;

    Boolean isEmailVerified;

    Boolean isDocVerified;

    Photo avatar;
}
