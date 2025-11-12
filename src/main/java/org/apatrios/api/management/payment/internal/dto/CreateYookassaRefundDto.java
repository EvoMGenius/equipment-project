package org.apatrios.api.management.payment.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.Amount;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для возврата платежа с юкассы")
public class CreateYookassaRefundDto {

    @Schema(description = "id оплаты")
    UUID paymentId;

    @Schema(description = "Сумма платежа до оплаты")
    Amount amount;
}
