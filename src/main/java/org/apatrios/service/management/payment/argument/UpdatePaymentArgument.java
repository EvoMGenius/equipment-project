package org.apatrios.service.management.payment.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.dictoinary.PurchaseType;
import org.apatrios.model.management.PaymentStatus;

import java.math.BigDecimal;
import java.util.Map;

@Value
@Builder
public class UpdatePaymentArgument {
    PurchaseType paymentType;
    Dict entityType;
    String currency;
    BigDecimal amount;
    PaymentStatus status;
    Map<String, String> metadata;
}
