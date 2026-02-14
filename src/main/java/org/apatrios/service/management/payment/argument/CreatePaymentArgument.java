package org.apatrios.service.management.payment.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.dictoinary.PurchaseType;
import org.apatrios.model.equipment.Status;

import java.math.BigDecimal;
import java.util.Map;

@Value
@Builder
public class CreatePaymentArgument {
    PurchaseType paymentType;

    Dict entityType;

    String currency;

    BigDecimal amount;

    Status status;
}
