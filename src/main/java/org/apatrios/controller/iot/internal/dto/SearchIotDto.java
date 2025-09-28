package org.apatrios.controller.iot.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BikeStatus;
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

    @Schema(description = "Статус IoT-устройства", example = "ACTIVE")
    BikeStatus status;

    @Schema(description = "Комментарий или примечание", example = "Устройство установлено на велосипед №12")
    String comment;
}