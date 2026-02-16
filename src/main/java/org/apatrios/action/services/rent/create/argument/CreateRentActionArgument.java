package org.apatrios.action.services.rent.create.argument;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Value
@Builder
public class CreateRentActionArgument {
    String number;
    UUID userId;
    UUID bikeId;
    UUID pointId;
    List<UUID> debtIds;
    Integer total;
    Integer currentDays;
    Integer delay;
    BigDecimal delayCost;
    List<UUID> outfitIds;
    List<UUID> documentIds;
    UUID rentTypeId;
}
