package org.apatrios.service.management.tariff.argument;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder
public class SearchTariffArgument {
    String code;

    UUID tariffTypeId;

    Integer startBorder;

    Integer endBorder;

    Integer sale;

    BigDecimal cost;

    UUID statusId;
}
