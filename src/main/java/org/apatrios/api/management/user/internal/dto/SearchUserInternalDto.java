package org.apatrios.api.management.user.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.UserStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "ДТО юзера")
public class SearchUserInternalDto {
    @Schema(description = "Логин пользователя", example = "jdoe")
    String username;

    @Schema(description = "Список ролей/прав доступа", example = "[\"ROLE_ADMIN\", \"ROLE_USER\"]")
    Set<String> authorities;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @Schema(description = "Строка поиска")
    String searchString;

    @Schema(description = "Статус пользователя", example = "ACTIVE")
    UserStatus status;

    @Schema(description = "Дата последнего входа (с)", example = "2023-01-01T00:00:00")
    LocalDateTime lastLoginFrom;

    @Schema(description = "Дата последнего входа (по)", example = "2023-12-31T23:59:59")
    LocalDateTime lastLoginTo;

    @Schema(description = "Дата создания (с)", example = "2023-01-01T00:00:00")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания (по)", example = "2023-12-31T23:59:59")
    LocalDateTime createDateTo;

    @Schema(description = "Дата обновления (с)", example = "2023-01-01T00:00:00")
    LocalDateTime updateDateFrom;

    @Schema(description = "Дата обновления (по)", example = "2023-12-31T23:59:59")
    LocalDateTime updateDateTo;

    @Schema(description = "Флаг активности (true = включен, false = отключен)", example = "true")
    boolean enabled;

    @Schema(description = "Фамилия пользователя", example = "Иванов")
    String lastName;

    @Schema(description = "Имя пользователя", example = "Иван")
    String firstName;

    @Schema(description = "Отчество пользователя", example = "Иванович")
    String middleName;
}
