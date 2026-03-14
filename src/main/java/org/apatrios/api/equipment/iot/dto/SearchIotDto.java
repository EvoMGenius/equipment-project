package org.apatrios.api.equipment.iot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.equipment.IotStatus;

import java.util.UUID;

@Schema(description = "Параметры для фильтрации и поиска IOT-модулей")
public record SearchIotDto(

        @Schema(description = "Фильтр по модели IOT", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID modelId,

        @Schema(description = "Поиск по инвентарному номеру (частичное совпадение)", example = "IOT-V")
        String invNumber,

        @Schema(description = "Поиск по IMEI (частичное совпадение)", example = "35412")
        String imei,

        @Schema(description = "Фильтр по признаку удаления (true/false)", example = "false")
        Boolean isDeleted,

        @Schema(description = "Фильтр по текущему статусу модуля")
        IotStatus status,

        @Schema(description = "Фильтр по принадлежности компании", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
        UUID companyId
) {
}