package org.apatrios.action.equipment.iot;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.equipment.iot.argument.CreateIotActionArgument;
import org.apatrios.model.dictoinary.IotModel;
import org.apatrios.model.equipment.Iot;
import org.apatrios.model.management.Company;
import org.apatrios.service.dictionary.IotModelService;
import org.apatrios.service.equipment.iot.IotService;
import org.apatrios.service.equipment.iot.argument.CreateIotArgument;
import org.apatrios.service.management.company.CompanyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class CreateIotAction implements Action<CreateIotActionArgument, Iot> {

    IotService iotService;
    IotModelService iotModelService;
    CompanyService companyService;

    @Override
    @Transactional
    public Iot execute(@NonNull CreateIotActionArgument argument) {
        IotModel iotModel = iotModelService.getExisting(argument.iotModelId());
        Company company = companyService.getExisting(argument.companyId());

        return iotService.create(CreateIotArgument.builder()
                                                  .iotModel(iotModel)
                                                  .invNumber(argument.invNumber())
                                                  .company(company)
                                                  .imei(argument.imei())
                                                  .simId(argument.simId())
                                                  .comment(argument.comment())
                                                  .build());
    }
}