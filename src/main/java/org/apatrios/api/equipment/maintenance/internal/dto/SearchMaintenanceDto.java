package org.apatrios.api.equipment.maintenance.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.equipment.MaintenanceStatus;

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
@Schema(description = "DTO поиска Техобслуживания")
public class SearchMaintenanceDto {

    @Schema(description = "ID")
    UUID id;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @Schema(description = "Строка поиска")
    String searchString;

    @Schema(description = "VIN (идентификатор) велосипеда, по которому выполняется поиск")
    String bicycleVin;

    @Schema(description = "Список выполненных работ для фильтрации записей")
    String completedWork;

    @Schema(description = "Дата начала техобслуживания (нижняя граница диапазона)")
    LocalDateTime startDateFrom;

    @Schema(description = "Дата начала техобслуживания (верхняя граница диапазона)")
    LocalDateTime startDateTo;

    @Schema(description = "Дата окончания техобслуживания (нижняя граница диапазона)")
    LocalDateTime endDateFrom;

    @Schema(description = "Дата окончания техобслуживания (верхняя граница диапазона)")
    LocalDateTime endDateTo;

    @Schema(description = "Дата создания записи (нижняя граница диапазона)")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания записи (верхняя граница диапазона)")
    LocalDateTime createDateTo;

    @Schema(description = "Дата обновления записи (нижняя граница диапазона)")
    LocalDateTime updateDateFrom;

    @Schema(description = "Дата обновления записи (верхняя граница диапазона)")
    LocalDateTime updateDateTo;

    @Schema(description = "Фильтр по логически удалённым записям (true — только удалённые, false — только активные)")
    boolean isDeleted;

    @Schema(description = "Статус техобслуживания (enum MaintenanceStatus)")
    MaintenanceStatus status;
}
