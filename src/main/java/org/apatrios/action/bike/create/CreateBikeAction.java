package org.apatrios.action.bike.create;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.Bike;
import org.apatrios.model.Iot;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.service.bike.BikeService;
import org.apatrios.service.bike.argument.CreateBikeArgument;
import org.apatrios.service.dictionary.ModelBikeService;
import org.apatrios.service.iot.IotService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class CreateBikeAction implements Action<CreateBikeActionArgument, Bike> {

    BikeService bikeService;
    IotService iotService;
    ModelBikeService modelBikeService;

    @Override
    @Transactional
    public Bike execute(@NonNull CreateBikeActionArgument argument) {
        Iot iot = iotService.getExisting(argument.getIotId());
        ModelBike modelBike = modelBikeService.getExisting(argument.getModelBikeId());

        return bikeService.create(CreateBikeArgument.builder()
                                                    .iot(iot)
                                                    .modelBike(modelBike)
                                                    .vin(argument.getVin())
                                                    .comment(argument.getComment())
                                                    .invNumber(argument.getInvNumber())
                                                    .seqNumber(argument.getSeqNumber())
                                                    .motorWheel(argument.getMotorWheel())
                                                    .build());
    }
}
