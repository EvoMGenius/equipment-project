package org.apatrios.action.management.payment.webhook.handler;

import org.apatrios.action.management.payment.webhook.common.argument.YookassaPaymentWebhookActionArgument;

import java.util.List;

public interface YookassaWebhookHandler {

    /**
     * Тип события который обрабатывает handler
     */
    List<String> getEventTypes();

    /**
     * Обработать webhook
     */
    void handle(YookassaPaymentWebhookActionArgument argument);
}
