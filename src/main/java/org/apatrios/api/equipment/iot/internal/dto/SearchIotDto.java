package org.apatrios.api.equipment.iot.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.equipment.IotStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO поиска IoT-устройств")
public class SearchIotDto {
    @Schema(description = "id модели IoT-устройства")
    UUID iotModelId;

    @Schema(description = "Инвентарный номер IoT-устройства")
    String invNumber;

    @Schema(description = "id SIM-карты")
    UUID simId;

    @Schema(description = "IMEI")
    String imei;

    @Schema(description = "Статус IoT-устройства", example = "ACTIVE")
    IotStatus status;

    @Schema(description = "Комментарий или примечание", example = "Устройство установлено на велосипед №12")
    String comment;

    @Schema(description = "Дата создания начало")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания конец")
    LocalDateTime createDateTo;

    @Schema(description = "Дата обновления начало")
    LocalDateTime updateDateFrom;

    @Schema(description = "Дата обновления начало")
    LocalDateTime updateDateTo;

    @Schema(description = "Признак удаления")
    boolean isDeleted;
}