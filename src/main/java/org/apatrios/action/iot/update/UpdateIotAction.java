package org.apatrios.action.iot.update;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.action.Action;
import org.apatrios.model.Iot;
import org.apatrios.model.Sim;
import org.apatrios.model.dictoinary.IotModel;
import org.apatrios.service.dictionary.IotModelService;
import org.apatrios.service.iot.IotService;
import org.apatrios.service.iot.argument.UpdateIotArgument;
import org.apatrios.service.sim.SimService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
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
                                                  .build());
    }
}
