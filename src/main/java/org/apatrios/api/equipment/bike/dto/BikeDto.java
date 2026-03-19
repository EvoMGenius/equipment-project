package org.apatrios.api.equipment.bike.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.api.dictionary.model_bike.dto.ModelBikeDto;
import org.apatrios.api.equipment.iot.dto.IotDto;
import org.apatrios.api.management.company.dto.CompanyDto;
import org.apatrios.model.equipment.BikeStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "DTO велосипеда")
public record BikeDto(
        @Schema(description = "Уникальный идентификатор")
        UUID id,

        @Schema(description = "Модель велосипеда")
        ModelBikeDto modelBike,

        @Schema(description = "Инвентарный номер", example = "100500")
        Integer invNumber,

        @Schema(description = "Порядковый номер внутри модели")
        Integer seqNumber,

        @Schema(description = "VIN номер")
        String vin,

        @Schema(description = "Номер мотор-колеса")
        String motorWheel,

        @Schema(description = "IOT-модуль")
        IotDto iot,

        @Schema(description = "Компания")
        CompanyDto company,

        @Schema(description = "Текущий статус")
        BikeStatus status,

        @Schema(description = "Комментарий")
        String comment,

        @Schema(description = "Дата создания")
        LocalDateTime createDate,

        @Schema(description = "Дата обновления")
        LocalDateTime updateDate,

        @Schema(description = "Признак удаления")
        Boolean isDeleted
) {}