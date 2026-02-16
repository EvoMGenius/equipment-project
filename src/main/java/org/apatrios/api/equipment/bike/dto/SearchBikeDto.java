package org.apatrios.api.equipment.bike.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.equipment.BikeStatus;

import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO поиска велосипеда")
public class SearchBikeDto {
    @Schema(description = "Поиск по инвентарному номеру (частичное совпадение)")
    String invNumber;

    @Schema(description = "Фильтр по конкретной модели велосипеда")
    UUID modelBikeId;

    @Schema(description = "Фильтр по идентификатору телеметрии")
    UUID telemetryId;

    @Schema(description = "Фильтр по состоянию блокировки")
    Boolean isBlocked;

    @Schema(description = "Фильтр по состоянию сигнализации")
    Boolean isAlarmOn;

    @Schema(description = "Фильтр по состоянию фар")
    Boolean isHeadlightsOn;

    @Schema(description = "Фильтр по наличию определенных тарифов")
    List<UUID> tariffIds;

    @Schema(description = "Фильтр по выбранному тарифу")
    UUID chosenTariffId;

    @Schema(description = "Текущий статус велосипеда")
    BikeStatus status;
}
