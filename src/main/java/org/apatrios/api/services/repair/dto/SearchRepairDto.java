package org.apatrios.api.services.repair.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.services.RepairStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "DTO для поиска заявок на ремонт")
public record SearchRepairDto(

        @Schema(description = "Поиск по номеру заявки")
        String number,

        @Schema(description = "Описание проблемы")
        String problem,

        @Schema(description = "Строка поиска")
        String searchString,

        @Schema(description = "Текущий статус ремонта")
        RepairStatus status,

        @Schema(description = "Фильтр по типу ремонта")
        String fixType,

        @Schema(description = "Фильтр по сервисному центру")
        UUID pointId,

        @Schema(description = "Фильтр по дате создания (С)")
        LocalDateTime createDateFrom,

        @Schema(description = "Фильтр по дате создания (ПО)")
        LocalDateTime createDateTo
) {}