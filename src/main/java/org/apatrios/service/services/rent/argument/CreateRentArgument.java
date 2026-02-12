package org.apatrios.service.services.rent.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.Status;
import org.apatrios.model.equipment.Bike;
import org.apatrios.model.equipment.Outfit;
import org.apatrios.model.management.Point;
import org.apatrios.model.management.User;
import org.apatrios.model.services.Debt;
import org.apatrios.model.management.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Value
@Builder
public class CreateRentArgument {
    String number;
    Status status;
    User user;
    Bike bike;
    Point point;
    List<Debt> debts;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Integer total;
    Integer currentDays;
    Integer delay;
    BigDecimal delayCost;
    List<Outfit> outfits;
    List<Document> documents;
}
