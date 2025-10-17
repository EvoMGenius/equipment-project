package org.apatrios.api.management.user.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "ДТО обновления пароля юзера")
public class UpdatePasswordInternalDto {
    @Schema(description = "Новый пароль")
    @NotBlank
    String password;
}
