package org.apatrios.api.management.user.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.management.staff.internal.dto.StaffDto;
import org.apatrios.model.management.UserProfile;
import org.apatrios.model.management.UserStatus;

import java.time.LocalDateTime;
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
@Schema(description = "ДТО юзера")
public class UserInternalDto {

    @Schema(description = "Логин", requiredMode = REQUIRED)
    String username;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @Schema(description = "Активна ли запись", requiredMode = REQUIRED)
    boolean enabled;

    @Schema(description = "Доступ учетной записи", requiredMode = REQUIRED)
    Set<String> authorities;

    @Schema(description = "Профиль", requiredMode = REQUIRED)
    UserProfile userProfile;

    @Schema(description = "Статус", requiredMode = REQUIRED)
    UserStatus status;

    @Schema(description = "Последний вход", requiredMode = REQUIRED)
    LocalDateTime lastLogin;

    @Schema(description = "Дата создания", requiredMode = REQUIRED)
    LocalDateTime createDate;

    @Schema(description = "Дата обновления", requiredMode = REQUIRED)
    LocalDateTime updateDate;
}
