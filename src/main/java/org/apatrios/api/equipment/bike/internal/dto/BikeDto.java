package org.apatrios.api.equipment.bike.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.model_bike.dto.ModelBikeDto;
import org.apatrios.api.equipment.iot.internal.dto.IotDto;
import org.apatrios.api.management.franchisee.internal.dto.FranchiseeDto;
import org.apatrios.model.equipment.BikeStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO велосипеда")
public class BikeDto {

    @Schema(description = "Уникальный идентификатор велосипеда")
    UUID id;

    @Schema(description = "Модель велосипеда (из справочника)")
    ModelBikeDto modelBike;

    @Schema(description = "Франчизи")
    FranchiseeDto franchisee;

    @Schema(description = "Порядковый номер внутри модели")
    Integer seqNumber;

    @Schema(description = "Инвентарный номер велосипеда")
    Integer invNumber;

    @Schema(description = "VIN — уникальный идентификатор транспортного средства")
    String vin;

    @Schema(description = "Марка/модель моторного колеса")
    String motorWheel;

    @Schema(description = "Привязанное IoT-устройство (SIM/IOT модуль)")
    IotDto iot;

    @Schema(description = "Статус велосипеда")
    BikeStatus status;

    @Schema(description = "Комментарий или дополнительная информация")
    String comment;

    @Schema(description = "Дата создания")
    LocalDateTime createDate;

    @Schema(description = "Дата обновления")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления")
    boolean isDeleted;
}
