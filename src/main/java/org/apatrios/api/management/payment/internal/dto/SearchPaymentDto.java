package org.apatrios.api.management.payment.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.model.management.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    @Schema(description = "Сумма платежа", example = "100.00")
    BigDecimal amount;

    @Schema(description = "Валюта платежа", example = "RUB")
    String currency;

    @Schema(description = "Тип оплаты", example = "CASH")
    PaymentType paymentType;

    @Schema(description = "Статус оплаты", example = "PAID")
    PaymentStatus status;

    @Schema(description = "Дата создания от", example = "2025-10-01T00:00:00")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания до", example = "2025-10-31T23:59:59")
    LocalDateTime createDateTo;

    @Schema(description = "Дата обновления от", example = "2025-10-01T00:00:00")
    LocalDateTime updateDateFrom;

    @Schema(description = "Дата обновления до", example = "2025-10-31T23:59:59")
    LocalDateTime updateDateTo;

    @Schema(description = "Внешний ключ на связанную сущность")
    UUID entityId;

    @Schema(description = "Тип связанной сущности (например 'rent', 'service')", example = "rent")
    String entityType;

    @Schema(description = "Признак удаления", example = "false")
    Boolean isDeleted;
}
