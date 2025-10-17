package org.apatrios.action.equipment.sim_balance.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.Sim;
import org.apatrios.model.equipment.SimBalance;
import org.apatrios.service.equipment.sim.SimService;
import org.apatrios.service.equipment.sim_balance.SimBalanceService;
import org.apatrios.service.equipment.sim_balance.argument.UpdateSimBalanceArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateSimBalanceAction implements Action<UpdateSimBalanceActionArgument, SimBalance> {

    SimBalanceService simBalanceService;
    SimService simService;

    @Override
    @Transactional
    public SimBalance execute(@NonNull UpdateSimBalanceActionArgument argument) {
        Sim sim = simService.getExisting(argument.getSimId());

        return simBalanceService.update(argument.getId(),
                                        UpdateSimBalanceArgument.builder()
                                                                .value(argument.getValue())
                                                                .createDate(argument.getCreateDate())
                                                                .sim(sim)
                                                                .build());
    }
}
