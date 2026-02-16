package org.apatrios.api.management.tariff.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.dict.dto.DictDto;
import org.apatrios.model.management.TariffStatus;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO с полной информацией о тарифе")
public class TariffDto {

    @Schema(description = "Уникальный строковый код тарифа", example = "PROMO_SUMMER_2026")
    String code;

    @Schema(description = "Тип тарифа (например: Поминутный, Абонемент)")
    DictDto tariffType;

    @Schema(description = "Нижняя граница применения тарифа (например, от 0 мин)", example = "0")
    Integer startBorder;

    @Schema(description = "Верхняя граница применения тарифа (например, до 60 мин)", example = "60")
    Integer endBorder;

    @Schema(description = "Размер скидки в процентах", example = "10")
    Integer sale;

    @Schema(description = "Базовая стоимость", example = "150.00")
    BigDecimal cost;

    @Schema(description = "Текущий статус тарифа (Активен, Архивный)")
    TariffStatus status;
}