package org.apatrios.api.equipment.maintenance.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
@Schema(description = "DTO создания Техобслуживания")
public class CreateMaintenanceDto {

    @NotBlank
    @Schema(description = "VIN (идентификатор) велосипеда")
    String bicycleVin;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @NotNull
    @Schema(description = "Список выполненных работ/задач в рамках техобслуживания")
    List<String> completedWork;

    @Schema(description = "Дата и время начала техобслуживания в формате ISO-8601")
    LocalDateTime startDate;

    @Schema(description = "Дата и время окончания техобслуживания в формате ISO-8601")
    LocalDateTime endDate;
}
