package org.apatrios.api.management.user.profile.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "ДТО получения кода с имейл")
public record ChangeEmailApproveDto(
        @Schema(description = "ID", requiredMode = REQUIRED)
        @NotNull
        UUID id,

        @Schema(description = "email", requiredMode = REQUIRED)
        @Email
        @NotBlank
        String email,

        @Schema(description = "Код", requiredMode = REQUIRED)
        @NotBlank
        String code
) {}
