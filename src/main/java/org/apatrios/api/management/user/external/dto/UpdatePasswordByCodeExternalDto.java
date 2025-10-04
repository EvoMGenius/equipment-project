package org.apatrios.api.management.user.external.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "Дто смены пароля по коду")
public class UpdatePasswordByCodeExternalDto {

    @NotBlank
    @Schema(description = "Пароль", requiredMode = REQUIRED)
    String password;

    @NotNull
    @Schema(description = "Код для сбрасывания пароля", requiredMode = REQUIRED)
    UUID code;
}