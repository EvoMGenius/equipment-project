package org.apatrios.api.equipment.bike.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для создания велосипеда")
public class CreateBikeDto {
    @Schema(description = "Инвентарный номер (уникальный заводской или внутренний код)", example = "BK-2026-001")
    String invNumber;

    @Schema(description = "Идентификатор модели велосипеда (ссылка на справочник моделей)")
    UUID modelBikeId;

    @Schema(description = "Идентификатор установленного телеметрического модуля")
    UUID telemetryId;

    @Schema(description = "Список идентификаторов тарифов, доступных для этой единицы")
    List<UUID> tariffIds;

    @Schema(description = "Идентификатор тарифа, выбранного по умолчанию или для текущей сессии")
    UUID chosenTariffId;

    @Schema(description = "Идентификатор начального статуса (например, 'Свободен')")
    UUID statusId;

    @Schema(description = "Начальное состояние блокировки двигателя/колес", defaultValue = "false")
    Boolean isBlocked;

    @Schema(description = "Начальное состояние сигнализации", defaultValue = "false")
    Boolean isAlarmOn;

    @Schema(description = "Состояние фар при создании", defaultValue = "false")
    Boolean isHeadlightsOn;
}
