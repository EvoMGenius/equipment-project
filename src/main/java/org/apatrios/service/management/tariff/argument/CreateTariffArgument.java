package org.apatrios.service.management.tariff.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.management.TariffStatus;

import java.math.BigDecimal;

@Value
@Builder
public class CreateTariffArgument {
    String code;

    Dict tariffType;

    Integer startBorder;

    Integer endBorder;

    Integer sale;

    BigDecimal cost;
}
