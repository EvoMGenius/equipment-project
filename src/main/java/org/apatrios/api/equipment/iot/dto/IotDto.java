package org.apatrios.api.equipment.iot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.api.dictionary.iot_model.dto.IotModelDto;
import org.apatrios.api.management.company.dto.CompanyDto;
import org.apatrios.model.equipment.IotStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Данные IOT-модуля")
public record IotDto(

        @Schema(description = "Уникальный идентификатор IOT-модуля")
        UUID id,

        @Schema(description = "Модель IOT-модуля (справочник)")
        IotModelDto iotModel,

        @Schema(description = "Инвентаризационный номер внутри велопарка")
        String invNumber,

        @Schema(description = "франчайзи")
        CompanyDto company,

        @Schema(description = "Международный идентификатор мобильного оборудования (IMEI)")
        String imei,

        @Schema(description = "Идентификатор сим-карты")
        UUID simId,

        @Schema(description = "Текущий статус модуля")
        IotStatus status,

        @Schema(description = "Комментарий к модулю или запчасти")
        String comment,

        @Schema(description = "Дата и время создания записи")
        LocalDateTime createDate,

        @Schema(description = "Дата и время последнего обновления")
        LocalDateTime updateDate,

        @Schema(description = "Признак удаления модуля")
        boolean isDeleted

) {
}