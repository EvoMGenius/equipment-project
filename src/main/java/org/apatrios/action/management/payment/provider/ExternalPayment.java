package org.apatrios.action.management.payment.provider;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ExternalPayment {
    String externalPaymentId;
    String confirmationUrl;
}
