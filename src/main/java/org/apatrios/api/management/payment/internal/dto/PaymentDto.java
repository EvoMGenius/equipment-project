package org.apatrios.api.management.payment.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.payment_type.dto.PaymentTypeDto;
import org.apatrios.model.management.Amount;
import org.apatrios.model.management.IncomeAmount;
import org.apatrios.model.management.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
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

    @Schema(description = "Уникальный идентификатор")
    UUID id;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @Schema(description = "Сумма платежа до оплаты")
    Amount amount;

    @Schema(description = "Сумма платежа после оплаты")
    IncomeAmount incomeAmount;

    @Schema(description = "Тип оплаты", example = "CASH", required = true)
    PaymentTypeDto paymentType;

    @Schema(description = "Статус оплаты", example = "PAID", required = true)
    PaymentStatus status;

    @Schema(description = "Внешний ключ на связанную сущность (аренда, услуга и т.д.)", example = "d290f1ee-6c54-4b01-90e6-d701748f0851")
    UUID entityId;

    @Schema(description = "Тип связанной сущности (например 'rent', 'service')", example = "rent")
    String entityType;

    @Schema(description = "Дата и время создания", example = "2025-10-01T12:34:56")
    LocalDateTime createDate;

    @Schema(description = "Дата и время обновления", example = "2025-10-02T09:15:00")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;

    @Schema(description = "URL по оплате с ЮКассы")
    String confirmationUrl;

    @Schema(description = "URL возврата с ЮКассы")
    String returnUrl;
}
