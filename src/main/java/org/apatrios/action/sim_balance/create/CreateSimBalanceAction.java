package org.apatrios.action.sim_balance.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.Sim;
import org.apatrios.model.SimBalance;
import org.apatrios.service.sim.SimService;
import org.apatrios.service.sim_balance.SimBalanceService;
import org.apatrios.service.sim_balance.argument.CreateSimBalanceArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateSimBalanceAction implements Action<CreateSimBalanceActionArgument, SimBalance> {

    SimBalanceService simBalanceService;
    SimService simService;

    @Override
    @Transactional
    public SimBalance execute(@NonNull CreateSimBalanceActionArgument argument) {
        Sim sim = simService.getExisting(argument.getSimId());

        return simBalanceService.create(CreateSimBalanceArgument.builder()
                                                                .value(argument.getValue())
                                                                .createDate(argument.getCreateDate())
                                                                .sim(sim)
                                                                .build());
    }
}
