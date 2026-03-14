package org.apatrios.api.equipment.iot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Schema(description = "Данные для создания нового IOT-модуля")
public record CreateIotDto(

        @NotNull
        @Schema(description = "Идентификатор модели IOT", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID iotModelId,

        @NotBlank
        @Schema(description = "Инвентаризационный номер")
        String invNumber,

        @NotNull
        @Schema(description = "Идентификатор компании", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
        UUID companyId,

        @NotBlank
        @Schema(description = "IMEI устройства", example = "354125081234567")
        String imei,

        @Schema(description = "Идентификатор сим-карты (опционально)")
        UUID simId,

        @Schema(description = "Дополнительный комментарий")
        String comment
) {
}