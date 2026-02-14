package org.apatrios.action.management.tariff.create;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder
public class CreateTariffActionArgument {
    String code;

    UUID tariffTypeId;

    Integer startBorder;

    Integer endBorder;

    Integer sale;

    BigDecimal cost;

    UUID statusId;
}
