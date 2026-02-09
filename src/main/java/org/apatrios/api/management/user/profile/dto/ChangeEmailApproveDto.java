package org.apatrios.api.management.user.profile.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "ДТО получения кода с имейл")
public class ChangeEmailApproveDto {
    @Schema(description = "ID", requiredMode = REQUIRED)
    @NonNull
    UUID id;

    @Schema(description = "email", requiredMode = REQUIRED)
    @NotBlank
    String email;

    @Schema(description = "Код", requiredMode = REQUIRED)
    @NotBlank
    String code;
}
