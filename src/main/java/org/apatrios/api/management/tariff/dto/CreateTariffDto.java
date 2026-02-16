package org.apatrios.api.management.tariff.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
public class CreateTariffDto {
    @Schema(description = "Уникальный код тарифа", requiredMode = Schema.RequiredMode.REQUIRED)
    String code;

    @Schema(description = "Идентификатор типа тарифа из справочника")
    UUID tariffTypeId;

    @Schema(description = "Начальная граница действия")
    Integer startBorder;

    @Schema(description = "Конечная граница действия")
    Integer endBorder;

    @Schema(description = "Процент скидки", defaultValue = "0")
    Integer sale;

    @Schema(description = "Установленная стоимость")
    BigDecimal cost;
}
