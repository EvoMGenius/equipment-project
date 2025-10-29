package org.apatrios.action.equipment.iot.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.Iot;
import org.apatrios.model.equipment.Sim;
import org.apatrios.model.dictoinary.IotModel;
import org.apatrios.service.dictionary.IotModelService;
import org.apatrios.service.equipment.iot.IotService;
import org.apatrios.service.equipment.iot.argument.UpdateIotArgument;
import org.apatrios.service.equipment.sim.SimService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateIotAction implements Action<UpdateIotActionArgument, Iot> {

    IotService iotService;
    SimService simService;
    IotModelService iotModelService;

    @Override
    @Transactional
    public Iot execute(@NonNull UpdateIotActionArgument argument) {
        Sim sim = simService.getExisting(argument.getSimId());
        IotModel iotModel = iotModelService.getExisting(argument.getIotModelId());

        return iotService.update(argument.getId(),
                                 UpdateIotArgument.builder()
                                                  .model(iotModel)
                                                  .invNumber(argument.getInvNumber())
                                                  .sim(sim)
                                                  .status(argument.getStatus())
                                                  .comment(argument.getComment())
                                                  .imei(argument.getImei())
                                                  .franchiseeIds(argument.getFranchiseeIds())
                                                  .build());
    }
}
