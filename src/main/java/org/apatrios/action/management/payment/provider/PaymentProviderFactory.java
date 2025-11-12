package org.apatrios.action.management.payment.provider;

import org.apatrios.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PaymentProviderFactory {

    private final Map<String, PaymentProvider> providerMap;

    public PaymentProviderFactory(List<PaymentProvider> providers) {
        this.providerMap = providers.stream().collect(Collectors.toMap(p -> p.getProviderName().toLowerCase(), Function.identity()));
    }

    /**
     * Получить провайдера по имени
     *
     * @param providerName название провайдера
     * @return провайдер
     * @throws EntityNotFoundException если провайдер не найден
     */
    public PaymentProvider getProvider(String providerName) {
        PaymentProvider provider = providerMap.get(providerName.toLowerCase());

        if (provider == null) {
            throw new EntityNotFoundException(
                    String.format("Payment provider '%s' not found. Available: %s",
                                  providerName,
                                  providerMap.keySet())
            );
        }

        return provider;
    }
}