package org.apatrios.api.management.tariff.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.management.TariffStatus;

import java.math.BigDecimal;
import java.util.UUID;

@Schema(description = "DTO для поиска и фильтрации тарифов")
public record SearchTariffDto(

        @Schema(description = "Уникальный код тарифа", example = "TARIFF_STANDARD")
        String code,

        @Schema(description = "ID типа тарифа")
        UUID tariffTypeId,

        @Schema(description = "Статус тарифа (например CREATED, ACTIVE, ARCHIVED)")
        TariffStatus status,

        @Schema(description = "Частота оплат (например monthly, biweekly)", example = "monthly")
        String paymentFrequency,

        @Schema(description = "Сумма одного платежа", example = "1500.00")
        BigDecimal installmentAmount,

        @Schema(description = "Количество платежей", example = "12")
        Integer installmentCount,

        @Schema(description = "Нижняя граница применения тарифа (в днях)", example = "0")
        Integer startBorder,

        @Schema(description = "Верхняя граница применения тарифа (в днях)", example = "365")
        Integer endBorder,

        @Schema(description = "Размер скидки за период аренды", example = "500.00")
        BigDecimal sale,

        @Schema(description = "Стоимость с учетом скидки", example = "14500.00")
        BigDecimal cost,

        @Schema(description = "Стоимость, указанная менеджером (может переопределять расчетную)", example = "14000.00")
        BigDecimal customPrice
) {}