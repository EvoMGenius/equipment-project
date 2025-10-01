package org.apatrios.action.equipment.sim.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.Sim;
import org.apatrios.model.dictoinary.Operator;
import org.apatrios.service.dictionary.OperatorService;
import org.apatrios.service.equipment.sim.SimService;
import org.apatrios.service.equipment.sim.argument.UpdateSimArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateSimAction implements Action<UpdateSimActionArgument, Sim> {

    SimService simService;
    OperatorService operatorService;

    @Override
    @Transactional
    public Sim execute(@NonNull UpdateSimActionArgument argument) {
        Operator operator = operatorService.getExisting(argument.getOperatorId());

        return simService.update(argument.getId(),
                                 UpdateSimArgument.builder()
                                                  .operator(operator)
                                                  .phoneNumber(argument.getPhoneNumber())
                                                  .build());
    }
}
