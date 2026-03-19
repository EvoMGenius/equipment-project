package org.apatrios.api.management.user.authentication.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "ДТО отправки кода через звонок")
public record CallAuthenticationRequestDto(
        @Schema(description = "Телефон", requiredMode = REQUIRED)
        @NotBlank
        String phoneNumber
) {}
