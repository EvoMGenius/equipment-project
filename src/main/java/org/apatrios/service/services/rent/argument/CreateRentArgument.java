package org.apatrios.service.services.rent.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.RentType;
import org.apatrios.model.equipment.Bike;
import org.apatrios.model.equipment.Outfit;
import org.apatrios.model.management.Payment;
import org.apatrios.model.management.Point;
import org.apatrios.model.management.User;
import org.apatrios.model.services.Debt;
import org.apatrios.model.management.Document;
import org.apatrios.model.services.RentStatus;

import java.math.BigDecimal;
import java.util.*;

@Value
@Builder
public class CreateRentArgument {
    RentType rentType;
    String number;
    User user;
    Bike bike;
    Point point;
    List<Debt> debts;
    Integer total;
    Integer currentDays;
    Integer delay;
    BigDecimal delayCost;
    List<Outfit> outfits;
    List<Document> documents;
    Payment payment;
}
