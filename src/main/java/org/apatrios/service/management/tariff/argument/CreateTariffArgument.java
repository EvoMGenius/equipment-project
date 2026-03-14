package org.apatrios.service.management.tariff.argument;

import lombok.Builder;
import org.apatrios.model.dictoinary.TariffType;

import java.math.BigDecimal;

@Builder
public record CreateTariffArgument(
        String code,
        TariffType tariffType,
        String paymentFrequency,
        BigDecimal installmentAmount,
        Integer installmentCount,
        Integer startBorder,
        Integer endBorder,
        BigDecimal sale,
        BigDecimal cost,
        BigDecimal customPrice
) {}
