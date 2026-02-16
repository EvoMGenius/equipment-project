package org.apatrios.api.management.payment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.PaymentStatus;

import java.math.BigDecimal;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для поиска и фильтрации платежей")
public class SearchPaymentDto {
    @Schema(description = "Фильтр по способу оплаты")
    UUID paymentTypeId;

    @Schema(description = "Фильтр по типу сущности")
    UUID entityTypeId;

    @Schema(description = "Фильтр по валюте")
    String currency;

    @Schema(description = "Поиск платежей с конкретной суммой")
    BigDecimal amount;

    @Schema(description = "Текущий статус платежа (Создан, Оплачен, Отменен)")
    PaymentStatus status;
}
