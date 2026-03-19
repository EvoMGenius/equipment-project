package org.apatrios.api.management.user.profile.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "ДТО отправки кода на имейл")
public record ChangeEmailRequestDto(
        @NotBlank
        @Email
        @Schema(description = "Имейл", requiredMode = REQUIRED)
        String email
) {}
