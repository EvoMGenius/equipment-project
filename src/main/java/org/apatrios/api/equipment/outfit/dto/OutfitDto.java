package org.apatrios.api.equipment.outfit.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.equipment.status.dto.StatusDto;
import org.apatrios.api.management.tariff.dto.TariffDto;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO экипировки")
public class OutfitDto {
    @Schema(description = "Наименование экипировки", example = "Шлем защитный (размер L)")
    String name;

    @Schema(description = "Список тарифов, доступных для данной экипировки")
    List<TariffDto> tariff;

    @Schema(description = "Выбранный тариф (заполняется, если экипировка находится в аренде)")
    TariffDto chosenTariff;

    @Schema(description = "Текущий статус экипировки (например: Доступно, В аренде, Списано)")
    StatusDto status;
}
