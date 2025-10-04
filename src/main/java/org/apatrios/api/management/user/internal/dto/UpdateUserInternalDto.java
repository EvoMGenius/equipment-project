package org.apatrios.api.management.user.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.management.staff.internal.dto.StaffDto;
import org.apatrios.model.management.Staff;
import org.apatrios.model.management.UserProfile;
import org.apatrios.model.management.UserStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "ДТО обновления юзера")
public class UpdateUserInternalDto {

    @NotNull
    @Schema(description = "ID", requiredMode = REQUIRED)
    UUID id;

    @Schema(description = "Логин")
    @NotBlank
    String username;

    @NotBlank
    @Schema(description = "Доступ учетной записи")
    Set<String> authorities;

    @NotNull
    @Schema(description = "Профиль", requiredMode = REQUIRED)
    UserProfile userProfile;

    @NotNull
    @Schema(description = "Сотрудник id", requiredMode = REQUIRED)
    UUID staffId;

    @NotNull
    @Schema(description = "Статус", requiredMode = REQUIRED)
    UserStatus status;
}
