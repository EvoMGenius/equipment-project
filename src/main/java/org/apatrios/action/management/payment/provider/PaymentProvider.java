package org.apatrios.action.management.payment.provider;

import org.apatrios.action.management.payment.create.CreatePaymentActionArgument;

public interface PaymentProvider {

    String getProviderName();

    /**
     * Создать платеж
     */
    ExternalPayment createExternalPayment(String key, CreatePaymentActionArgument argument);
}
