package org.apatrios.action.services.rent.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.Bike;
import org.apatrios.model.equipment.Outfit;
import org.apatrios.model.equipment.Status;
import org.apatrios.model.management.Document;
import org.apatrios.model.management.Point;
import org.apatrios.model.management.User;
import org.apatrios.model.services.Debt;
import org.apatrios.model.services.Rent;
import org.apatrios.service.equipment.bike.BikeService;
import org.apatrios.service.equipment.outfit.OutfitService;
import org.apatrios.service.equipment.status.StatusService;
import org.apatrios.service.management.document.DocumentService;
import org.apatrios.service.management.point.PointService;
import org.apatrios.service.management.user.UserService;
import org.apatrios.service.services.debt.DebtService;
import org.apatrios.service.services.rent.RentService;
import org.apatrios.service.services.rent.argument.CreateRentArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateRentAction implements Action<CreateRentActionArgument, Rent> {

    RentService rentService;
    BikeService bikeService;
    PointService pointService;
    DebtService debtService;
    DocumentService documentService;
    OutfitService outfitService;
    UserService userService;
    StatusService statusService;

    @Override
    @Transactional
    public Rent execute(@NonNull CreateRentActionArgument argument) {
        Bike bike = bikeService.getExisting(argument.getBikeId());
        Point point = pointService.getExisting(argument.getPointId());
        List<Debt> debts = debtService.getAllByIds(argument.getDebtIds());
        List<Document> documents = documentService.getAllByIds(argument.getDocumentIds());
        List<Outfit> outfits = outfitService.getAllByIds(argument.getOutfitIds());
        User user = userService.getExisting(argument.getUserId());
        Status status = statusService.getExisting(argument.getStatusId());

        return rentService.create(CreateRentArgument.builder()
                                                    .bike(bike)
                                                    .point(point)
                                                    .currentDays(argument.getCurrentDays())
                                                    .debts(debts)
                                                    .delay(argument.getDelay())
                                                    .delayCost(argument.getDelayCost())
                                                    .total(argument.getTotal())
                                                    .documents(documents)
                                                    .endDate(argument.getEndDate())
                                                    .number(argument.getNumber())
                                                    .outfits(outfits)
                                                    .startDate(argument.getStartDate())
                                                    .user(user)
                                                    .status(status)
                                                    .build());
    }
}
