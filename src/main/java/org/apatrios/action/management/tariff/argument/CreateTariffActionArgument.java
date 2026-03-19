package org.apatrios.action.management.tariff.argument;

import lombok.Builder;
import org.apatrios.model.dictoinary.TariffType;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record CreateTariffActionArgument(
        String code,
        UUID tariffTypeId,
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
