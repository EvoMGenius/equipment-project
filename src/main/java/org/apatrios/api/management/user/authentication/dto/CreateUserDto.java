package org.apatrios.api.management.user.authentication.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.UserProfile;

import javax.validation.constraints.NotBlank;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "ДТО создания пользователя")
public class CreateUserDto {
    @Schema(description = "Телефон", requiredMode = REQUIRED)
    @NotBlank
    String phoneNumber;

    @Schema(description = "Профиль", requiredMode = REQUIRED)
    @NonNull
    UserProfile userProfile;
}
