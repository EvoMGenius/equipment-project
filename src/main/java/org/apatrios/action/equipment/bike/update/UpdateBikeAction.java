package org.apatrios.action.equipment.bike.update;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.Bike;
import org.apatrios.model.equipment.Iot;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.management.Franchisee;
import org.apatrios.service.equipment.bike.BikeService;
import org.apatrios.service.equipment.bike.argument.UpdateBikeArgument;
import org.apatrios.service.dictionary.ModelBikeService;
import org.apatrios.service.equipment.iot.IotService;
import org.apatrios.service.management.franchisee.FranchiseeService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class UpdateBikeAction implements Action<UpdateBikeActionArgument, Bike> {

    BikeService bikeService;
    IotService iotService;
    ModelBikeService modelBikeService;
    FranchiseeService franchiseeService;

    @Override
    @Transactional
    public Bike execute(@NonNull UpdateBikeActionArgument argument) {
        Iot iot = iotService.getExisting(argument.getIotId());
        ModelBike modelBike = modelBikeService.getExisting(argument.getModelBikeId());
        Franchisee franchisee = franchiseeService.getExisting(argument.getFranchiseeId());

        return bikeService.update(argument.getId(),
                                  UpdateBikeArgument.builder()
                                                    .iot(iot)
                                                    .vin(argument.getVin())
                                                    .status(argument.getStatus())
                                                    .modelBike(modelBike)
                                                    .invNumber(argument.getInvNumber())
                                                    .seqNumber(argument.getSeqNumber())
                                                    .motorWheel(argument.getMotorWheel())
                                                    .comment(argument.getComment())
                                                    .franchisee(franchisee)
                                                    .build());
    }
}
