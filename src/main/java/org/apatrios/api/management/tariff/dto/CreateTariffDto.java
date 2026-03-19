package org.apatrios.api.management.tariff.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Schema(description = "DTO для создания нового тарифа")
public record CreateTariffDto(

        @NotBlank
        @Schema(description = "Уникальный код тарифа", example = "TARIFF_STANDARD")
        String code,

        @NotNull
        @Schema(description = "ID типа тарифа")
        UUID tariffTypeId,

        @NotBlank
        @Schema(description = "Частота оплат (например: monthly, biweekly)", example = "monthly")
        String paymentFrequency,

        @NotNull
        @Schema(description = "Сумма одного платежа", example = "1500.00")
        BigDecimal installmentAmount,

        @NotNull
        @Schema(description = "Количество платежей", example = "12")
        Integer installmentCount,

        @Schema(description = "Нижняя граница применения тарифа (в днях)", example = "0")
        Integer startBorder,

        @Schema(description = "Верхняя граница применения тарифа (в днях)", example = "365")
        Integer endBorder,

        @Schema(description = "Скидка за период аренды", example = "500.00")
        BigDecimal sale,

        @Schema(description = "Стоимость с учетом скидки", example = "14500.00")
        BigDecimal cost,

        @Schema(description = "Стоимость, указанная менеджером (может переопределять расчетную)", example = "14000.00")
        BigDecimal customPrice
) {}