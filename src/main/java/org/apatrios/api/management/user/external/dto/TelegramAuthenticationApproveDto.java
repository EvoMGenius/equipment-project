package org.apatrios.api.management.user.external.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "ДТО подтверждения кода через телеграмм")
public class TelegramAuthenticationApproveDto {

    @Schema(description = "Логин", requiredMode = REQUIRED)
    @NotBlank
    String login;

    @Schema(description = "Код", requiredMode = REQUIRED)
    @NotBlank
    String code;
}
