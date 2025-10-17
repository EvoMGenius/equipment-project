package org.apatrios.api.equipment.iot.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.iot_model.dto.IotModelDto;
import org.apatrios.api.equipment.sim.internal.dto.SimDto;
import org.apatrios.model.equipment.BikeStatus;
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
@Schema(description = "DTO IoT-устройств")
public class IotDto {
    @Schema(description = "Идентификатор IoT-устройства", example = "3f2b7c9d-5a23-4e91-8b41-12cd56e7a9ef")
    UUID id;

    @Schema(description = "Модель IoT-устройства")
    IotModelDto model;

    @Schema(description = "Инвентарный номер IoT-устройства", example = "IOT-12345")
    String invNumber;

    @Schema(description = "Привязанная SIM-карта")
    SimDto sim;

    @Schema(description = "Статус IoT-устройства", example = "ACTIVE")
    IotStatus status;

    @Schema(description = "Комментарий или примечание", example = "Устройство установлено на велосипед №12")
    String comment;

    @Schema(description = "Дата создания")
    LocalDateTime createDate;

    @Schema(description = "Дата обновления")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления")
    boolean isDeleted;

    @Schema(description = "IMEI")
    String imei;
}