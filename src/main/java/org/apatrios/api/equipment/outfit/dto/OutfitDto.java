package org.apatrios.api.equipment.outfit.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.api.management.tariff.dto.TariffDto;
import org.apatrios.model.equipment.OutfitStatus;

import java.util.List;
import java.util.UUID;

@Schema(description = "DTO экипировки")
public record OutfitDto(

        @Schema(description = "ID")
        UUID id,

        @Schema(description = "Наименование экипировки")
        String name,

        @Schema(description = "Список тарифов, доступных для данной экипировки")
        List<TariffDto> tariff,

        @Schema(description = "Выбранный тариф (заполняется, если экипировка находится в аренде)")
        TariffDto chosenTariff,

        @Schema(description = "Текущий статус экипировки (например: Доступно, В аренде, Списано)")
        OutfitStatus status
) {}