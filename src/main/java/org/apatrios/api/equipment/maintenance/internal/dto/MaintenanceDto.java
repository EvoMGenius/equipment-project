package org.apatrios.api.equipment.maintenance.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.equipment.MaintenanceStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO Техобслуживания")
public class MaintenanceDto {

    @Schema(description = "ID")
    UUID id;

    @Schema(description = "VIN (идентификатор) велосипеда")
    String bicycleVin;

    @Schema(description = "Список выполненных работ/задач в рамках техобслуживания")
    List<String> completedWork;

    @Schema(description = "Текущий статус техобслуживания (enum MaintenanceStatus)")
    MaintenanceStatus status;

    @Schema(description = "Дата и время начала техобслуживания в формате ISO-8601")
    LocalDateTime startDate;

    @Schema(description = "Дата и время окончания техобслуживания в формате ISO-8601")
    LocalDateTime endDate;

    @Schema(description = "Дата и время создания записи")
    LocalDateTime createDate;

    @Schema(description = "Дата и время последнего обновления записи")
    LocalDateTime updateDate;

    @Schema(description = "Флаг логического удаления записи")
    boolean isDeleted;
}
