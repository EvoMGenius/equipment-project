package org.apatrios.action.services.support;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.services.support.argument.CreateSupportActionArgument;
import org.apatrios.model.services.Repair;
import org.apatrios.model.services.Support;
import org.apatrios.service.services.repair.RepairService;
import org.apatrios.service.services.support.SupportService;
import org.apatrios.service.services.support.argument.CreateSupportArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateSupportAction implements Action<CreateSupportActionArgument, Support> {

    SupportService supportService;
    RepairService repairService;

    @Override
    @Transactional
    public Support execute(@NonNull CreateSupportActionArgument argument) {
        Repair repair = repairService.getExisting(argument.childRepairId());

        return supportService.create(CreateSupportArgument.builder()
                                                          .type(argument.type())
                                                          .description(argument.description())
                                                          .photo(argument.photos())
                                                          .childRepairId(repair)
                                                          .build());
    }
}
