package org.apatrios.api.management.payment.webhook.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.feign.payment.dto.YookassaPaymentDto;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class PaymentWebhookDto {
    String type;
    String event;
    YookassaPaymentDto object;
}
