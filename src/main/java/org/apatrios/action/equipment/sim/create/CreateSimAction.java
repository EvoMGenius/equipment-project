package org.apatrios.action.equipment.sim.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.Sim;
import org.apatrios.model.dictoinary.Operator;
import org.apatrios.service.dictionary.OperatorService;
import org.apatrios.service.equipment.sim.SimService;
import org.apatrios.service.equipment.sim.argument.CreateSimArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateSimAction implements Action<CreateSimActionArgument, Sim> {

    SimService simService;
    OperatorService operatorService;

    @Override
    @Transactional
    public Sim execute(@NonNull CreateSimActionArgument argument) {
        Operator operator = operatorService.getExisting(argument.getOperatorId());

        return simService.create(CreateSimArgument.builder()
                                                  .operator(operator)
                                                  .phoneNumber(argument.getPhoneNumber())
                                                  .build());
    }
}
