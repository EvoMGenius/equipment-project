package org.apatrios.action.iot.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.Iot;
import org.apatrios.model.Sim;
import org.apatrios.model.dictoinary.IotModel;
import org.apatrios.service.dictionary.IotModelService;
import org.apatrios.service.iot.IotService;
import org.apatrios.service.iot.argument.CreateIotArgument;
import org.apatrios.service.sim.SimService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateIotAction implements Action<CreateIotActionArgument, Iot> {

    IotService iotService;
    SimService simService;
    IotModelService iotModelService;

    @Override
    @Transactional
    public Iot execute(@NonNull CreateIotActionArgument argument) {
        Sim sim = simService.getExisting(argument.getSimId());
        IotModel iotModel = iotModelService.getExisting(argument.getIotModelId());

        return iotService.create(CreateIotArgument.builder()
                                                  .model(iotModel)
                                                  .invNumber(argument.getInvNumber())
                                                  .sim(sim)
                                                  .comment(argument.getComment())
                                                  .build());
    }
}
