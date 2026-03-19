package org.apatrios.api.management.tariff.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.api.dictionary.tariff_type.dto.TariffTypeDto;
import org.apatrios.model.management.TariffStatus;

import java.math.BigDecimal;
import java.util.UUID;

@Schema(description = "DTO с полной информацией о тарифе")
public record TariffDto(
        @Schema(description = "Уникальный идентификатор тарифа")
        UUID id,

        @Schema(description = "Уникальный код тарифа")
        String code,

        @Schema(description = "Тип тарифа")
        TariffTypeDto tariffType,

        @Schema(description = "Частота оплат (например: monthly, biweekly)")
        String paymentFrequency,

        @Schema(description = "Сумма одного платежа", example = "1500.00")
        BigDecimal installmentAmount,

        @Schema(description = "Общее количество платежей", example = "12")
        Integer installmentCount,

        @Schema(description = "Нижняя граница применения тарифа (в днях)")
        Integer startBorder,

        @Schema(description = "Верхняя граница применения тарифа (в днях)")
        Integer endBorder,

        @Schema(description = "Размер скидки за период аренды", example = "500.00")
        BigDecimal sale,

        @Schema(description = "Стоимость с учетом скидки", example = "14500.00")
        BigDecimal cost,

        @Schema(description = "Стоимость, указанная менеджером (может переопределять расчетную)")
        BigDecimal customPrice,

        @Schema(description = "Статус тарифа")
        TariffStatus status
) {}