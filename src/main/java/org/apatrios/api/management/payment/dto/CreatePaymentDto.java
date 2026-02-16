package org.apatrios.api.management.payment.dto;

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
@Schema(description = "DTO для создания нового платежа")
public class CreatePaymentDto {
    @Schema(description = "ID способа оплаты из справочника")
    UUID paymentTypeId;

    @Schema(description = "ID типа оплачиваемой сущности")
    UUID entityTypeId;

    @Schema(description = "Код валюты (ISO 4217)", defaultValue = "RUB")
    String currency;

    @Schema(description = "Сумма к оплате")
    BigDecimal amount;
}
