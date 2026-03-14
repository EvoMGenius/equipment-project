package org.apatrios.api.management.user.authentication.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.management.UserProfile;

import javax.validation.constraints.NotNull;

import java.util.UUID;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "ДТО создания пользователя")
public record CompleteRegistrationUserDto(
        @Schema(description = "ID", requiredMode = REQUIRED)
        @NotNull
        UUID id,

        @Schema(description = "Профиль", requiredMode = REQUIRED)
        @NotNull
        UserProfile userProfile
) {}
