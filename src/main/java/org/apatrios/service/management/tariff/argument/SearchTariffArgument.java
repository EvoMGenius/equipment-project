package org.apatrios.service.management.tariff.argument;

import lombok.Builder;
import org.apatrios.model.management.TariffStatus;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record SearchTariffArgument(
        String code,
        UUID tariffTypeId,
        TariffStatus status,
        String paymentFrequency,
        BigDecimal installmentAmount,
        Integer installmentCount,
        Integer startBorder,
        Integer endBorder,
        BigDecimal sale,
        BigDecimal cost,
        BigDecimal customPrice
) {
}
