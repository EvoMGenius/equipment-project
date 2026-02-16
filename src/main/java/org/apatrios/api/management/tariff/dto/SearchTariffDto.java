package org.apatrios.api.management.tariff.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.TariffStatus;

import java.math.BigDecimal;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для информации о точке")
public class SearchTariffDto {
    @Schema(description = "Фильтр по коду тарифа (частичное совпадение)")
    String code;

    @Schema(description = "Фильтр по идентификатору типа тарифа")
    UUID tariffTypeId;

    @Schema(description = "Поиск по нижней границе")
    Integer startBorder;

    @Schema(description = "Поиск по верхней границе")
    Integer endBorder;

    @Schema(description = "Фильтр по размеру скидки")
    Integer sale;

    @Schema(description = "Фильтр по стоимости")
    BigDecimal cost;

    @Schema(description = "Текущий статус тарифа (Активен, Архивный)")
    TariffStatus status;
}
