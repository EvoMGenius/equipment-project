package org.apatrios.api.equipment.maintenance.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.equipment.MaintenanceStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO обновления Техобслуживания")
public class UpdateMaintenanceDto {

    @NotNull
    @Schema(description = "ID")
    UUID id;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @NotBlank
    @Schema(description = "VIN (идентификатор) велосипеда")
    String bicycleVin;

    @NotBlank
    @Schema(description = "Список выполненных работ/задач в рамках техобслуживания")
    List<String> completedWork;

    @NotNull
    @Schema(description = "Текущий статус техобслуживания (enum MaintenanceStatus)")
    MaintenanceStatus status;

    @Schema(description = "Дата и время начала техобслуживания в формате ISO-8601")
    LocalDateTime startDate;

    @Schema(description = "Дата и время окончания техобслуживания в формате ISO-8601")
    LocalDateTime endDate;
}
