package org.apatrios.api.management.staff.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.Position;
import org.apatrios.model.management.StaffStatus;

import java.time.LocalDateTime;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для поиска и фильтрации сотрудников")
public class SearchStaffDto {

    @Schema(description = "Имя или фамилия сотрудника", example = "Иванов")
    String name;

    @Schema(description = "Строка поиска")
    String searchString;

    @Schema(description = "Должность сотрудника", example = "MANAGER")
    Position position;

    @Schema(description = "Статус сотрудника", example = "ACTIVE")
    StaffStatus status;

    @Schema(description = "Дата создания от", example = "2025-10-01T00:00:00")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания до", example = "2025-10-31T23:59:59")
    LocalDateTime createDateTo;

    @Schema(description = "Дата обновления от", example = "2025-10-01T00:00:00")
    LocalDateTime updateDateFrom;

    @Schema(description = "Дата обновления до", example = "2025-10-31T23:59:59")
    LocalDateTime updateDateTo;

    @Schema(description = "Признак удаления", example = "false")
    Boolean isDeleted;
}
