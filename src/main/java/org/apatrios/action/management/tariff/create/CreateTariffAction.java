package org.apatrios.action.management.tariff.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.equipment.Status;
import org.apatrios.model.management.Tariff;
import org.apatrios.service.dictionary.DictService;
import org.apatrios.service.equipment.status.StatusService;
import org.apatrios.service.management.tariff.TariffService;
import org.apatrios.service.management.tariff.argument.CreateTariffArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateTariffAction implements Action<CreateTariffActionArgument, Tariff> {

    TariffService tariffService;
    DictService dictService;
    StatusService statusService;

    @Override
    @Transactional
    public Tariff execute(@NonNull CreateTariffActionArgument argument) {
        Dict dict = dictService.getExisting(argument.getTariffTypeId());
        Status status = statusService.getExisting(argument.getStatusId());

        return tariffService.create(CreateTariffArgument.builder()
                                                        .code(argument.getCode())
                                                        .cost(argument.getCost())
                                                        .endBorder(argument.getEndBorder())
                                                        .startBorder(argument.getStartBorder())
                                                        .sale(argument.getSale())
                                                        .tariffType(dict)
                                                        .status(status)
                                                        .build());
    }
}
