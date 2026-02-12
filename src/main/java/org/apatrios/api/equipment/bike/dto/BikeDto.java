package org.apatrios.api.equipment.bike.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.model_bike.dto.ModelBikeDto;
import org.apatrios.api.equipment.status.dto.StatusDto;
import org.apatrios.api.management.tariff.dto.TariffDto;

import java.util.List;
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

    @Schema(description = "Модель велосипеда")
    ModelBikeDto modelBike;

    @Schema(description = "Инвентарный номер устройства")
    String invNumber;

    @Schema(description = "Флаг блокировки колеса/двигателя")
    Boolean isBlocked;

    @Schema(description = "Статус сигнализации")
    Boolean isAlarmOn;

    @Schema(description = "Состояние фар")
    Boolean isHeadlightsOn;

    @Schema(description = "Список доступных тарифов для данного велосипеда")
    List<TariffDto> tariff;

    @Schema(description = "Текущий выбранный тариф")
    TariffDto chosenTariff;

    @Schema(description = "Текущий статус велосипеда")
    StatusDto status;
}
