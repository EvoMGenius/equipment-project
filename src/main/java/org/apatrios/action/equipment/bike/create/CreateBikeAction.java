package org.apatrios.action.equipment.bike.create;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.equipment.bike.create.argument.CreateBikeActionArgument;
import org.apatrios.model.equipment.Bike;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.equipment.Iot;
import org.apatrios.model.management.Company;
import org.apatrios.service.equipment.bike.BikeService;
import org.apatrios.service.equipment.bike.argument.CreateBikeArgument;
import org.apatrios.service.dictionary.ModelBikeService;
import org.apatrios.service.equipment.iot.IotService;
import org.apatrios.service.management.company.CompanyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class CreateBikeAction implements Action<CreateBikeActionArgument, Bike> {

    BikeService bikeService;
    ModelBikeService modelBikeService;
    CompanyService companyService;
    IotService iotService;

    @Override
    @Transactional
    public Bike execute(@NonNull CreateBikeActionArgument argument) {
        ModelBike modelBike = modelBikeService.getExisting(argument.modelBikeId());
        Company company = companyService.getExisting(argument.companyId());
        Iot iot = iotService.getExisting(argument.iotId());

        return bikeService.create(CreateBikeArgument.builder()
                                                    .invNumber(argument.invNumber())
                                                    .seqNumber(argument.seqNumber())
                                                    .company(company)
                                                    .motorWheel(argument.motorWheel())
                                                    .modelBike(modelBike)
                                                    .iot(iot)
                                                    .vin(argument.vin())
                                                    .comment(argument.comment())
                                                    .build());
    }
}
