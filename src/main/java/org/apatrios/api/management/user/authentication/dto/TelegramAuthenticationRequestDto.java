package org.apatrios.api.management.user.authentication.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Запрос на регистрацию пользователя через телеграмм")
public record TelegramAuthenticationRequestDto(
        @Schema(description = "Телефон", requiredMode = REQUIRED)
        @NotBlank
        String phoneNumber
) {}

