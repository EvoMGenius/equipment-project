package org.apatrios.action.services.rent.create;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateRentActionArgument {
    String number;
    UUID statusId;
    UUID userId;
    UUID bikeId;
    UUID pointId;
    List<UUID> debtIds;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Integer total;
    Integer currentDays;
    Integer delay;
    BigDecimal delayCost;
    List<UUID> outfitIds;
    List<UUID> documentIds;
    UUID rentTypeId;
}
