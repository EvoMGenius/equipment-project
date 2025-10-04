package org.apatrios.api.management.user.external.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.UserProfile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "Запрос на регистрацию пользователя")
public class CreateUserExternalDto {
    @Schema(description = "Логин", requiredMode = REQUIRED)
    @NotBlank
    String username;

    @Schema(description = "Пароль", requiredMode = REQUIRED)
    @NotBlank
    String password;

    @NotNull
    @Schema(description = "Профиль", requiredMode = REQUIRED)
    UserProfile userProfile;
}

