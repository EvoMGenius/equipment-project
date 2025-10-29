package org.apatrios.api.management.payment.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.PaymentStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для обновления информации о платеже")
public class UpdatePaymentDto {

    @NotNull
    @Schema(description = "ID")
    UUID id;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @Schema(description = "Сумма платежа", example = "1000.50", required = true)
    @NotNull
    BigDecimal amount;

    @Schema(description = "Валюта платежа", example = "RUB", required = true)
    @NotBlank
    String currency;

    @Schema(description = "id Тип оплаты")
    @NotNull
    UUID paymentTypeId;

    @Schema(description = "Внешний ключ на связанную сущность (аренда, услуга и т.д.)", example = "d290f1ee-6c54-4b01-90e6-d701748f0851")
    @NotNull
    UUID entityId;

    @Schema(description = "Тип связанной сущности (например 'rent', 'service')", example = "rent")
    @NotBlank
    String entityType;

    @Schema(description = "Статус оплаты", example = "PAID", required = true)
    PaymentStatus status;
}
