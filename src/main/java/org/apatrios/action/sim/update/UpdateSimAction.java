package org.apatrios.action.sim.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.Sim;
import org.apatrios.model.dictoinary.Operator;
import org.apatrios.service.dictionary.OperatorService;
import org.apatrios.service.sim.SimService;
import org.apatrios.service.sim.argument.UpdateSimArgument;
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
