package org.apatrios.api.management.management_point.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.PointStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для поиска информации о точке")
public class SearchManagementPointDto {
    @Schema(description = "Название точки", example = "Пункт выдачи №1")
    String name;

    @Schema(description = "Строка поиска")
    String searchString;

    @Schema(description = "Физический адрес точки", example = "г. Москва, ул. Ленина, 1")
    String address;

    @Schema(description = "ID Тип точки")
    UUID pointTypeId;

    @Schema(description = "Статус точки", example = "ACTIVE")
    PointStatus status;

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
