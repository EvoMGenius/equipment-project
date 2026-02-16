package org.apatrios.service.services.rent.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.Outfit;
import org.apatrios.model.services.RentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class SearchRentArgument {
    String number;
    UUID rentTypeId;
    RentStatus status;
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
    List<UUID> outfits;
    List<UUID> documentIds;
    String searchString;
    UUID paymentId;
}
