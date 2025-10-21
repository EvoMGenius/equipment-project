package org.apatrios.api.equipment.iot.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.equipment.BikeStatus;
import org.apatrios.model.equipment.IotStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO обновления IoT-устройств")
public class UpdateIotDto {

    @NotNull
    @Schema(description = "Идентификатор IoT-устройства", example = "3f2b7c9d-5a23-4e91-8b41-12cd56e7a9ef")
    UUID id;

    @NotNull
    @Schema(description = "id модели IoT-устройства")
    UUID iotModelId;

    @NotBlank
    @Schema(description = "Инвентарный номер IoT-устройства")
    String invNumber;

    @NotBlank
    @Schema(description = "IMEI")
    String imei;

    @NotNull
    @Schema(description = "id SIM-карты")
    UUID simId;

    @NotNull
    @Schema(description = "Статус IoT-устройства", example = "ACTIVE")
    IotStatus status;

    @Schema(description = "Комментарий или примечание", example = "Устройство установлено на велосипед №12")
    String comment;
}