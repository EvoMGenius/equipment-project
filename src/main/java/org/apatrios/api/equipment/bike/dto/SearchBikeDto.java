package org.apatrios.api.equipment.bike.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.equipment.BikeStatus;
import java.util.UUID;

@Schema(description = "DTO поиска велосипеда")
public record SearchBikeDto(
        @Schema(description = "Поиск по инвентарному номеру")
        Integer invNumber,

        @Schema(description = "Фильтр по модели")
        UUID modelBikeId,

        @Schema(description = "Фильтр по VIN")
        String vin,

        @Schema(description = "Фильтр по IOT-модулю")
        UUID iotId,

        @Schema(description = "Фильтр по компании")
        UUID companyId,

        @Schema(description = "Фильтр по статусу")
        BikeStatus status,

        @Schema(description = "Показать удаленные")
        Boolean isDeleted
) {}