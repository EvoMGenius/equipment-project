package org.apatrios.api.management.payment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.dict.dto.DictDto;
import org.apatrios.model.management.PaymentStatus;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для информации об оплате")
public class PaymentDto {

    @Schema(description = "ID")
    UUID id;

    @Schema(description = "Способ оплаты (например: Картой, СБП, Электронный кошелек)")
    DictDto paymentType;

    @Schema(description = "Тип оплачиваемой сущности (например: Аренда, Штраф, Депозит)")
    DictDto entityType;

    @Schema(description = "Валюта платежа", example = "RUB")
    String currency;

    @Schema(description = "Сумма платежа", example = "450.00")
    BigDecimal amount;

    @Schema(description = "Текущий статус платежа (Создан, Оплачен, Отменен)")
    PaymentStatus status;

    @Schema(description = "Метаданные от платежки")
    Map<String, String> metadata;
}
