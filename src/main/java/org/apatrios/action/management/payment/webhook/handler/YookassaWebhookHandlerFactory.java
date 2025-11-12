package org.apatrios.action.management.payment.webhook.handler;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class YookassaWebhookHandlerFactory {

    private final Map<String, YookassaWebhookHandler> handlers;

    public YookassaWebhookHandlerFactory(List<YookassaWebhookHandler> handlerList) {
        this.handlers = handlerList.stream()
                                   .flatMap(handler -> handler.getEventTypes().stream().map(eventType -> Map.entry(eventType.toLowerCase(), handler)))
                                   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public YookassaWebhookHandler getHandler(String eventType) {
        return handlers.get(eventType.toLowerCase());
    }
}
