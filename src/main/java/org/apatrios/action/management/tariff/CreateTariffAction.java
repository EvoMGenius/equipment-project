package org.apatrios.action.management.tariff;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.tariff.argument.CreateTariffActionArgument;
import org.apatrios.model.dictoinary.TariffType;
import org.apatrios.model.management.Tariff;
import org.apatrios.service.dictionary.TariffTypeService;
import org.apatrios.service.management.tariff.TariffService;
import org.apatrios.service.management.tariff.argument.CreateTariffArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateTariffAction implements Action<CreateTariffActionArgument, Tariff> {

    TariffService tariffService;
    TariffTypeService tariffTypeService;

    @Override
    @Transactional
    public Tariff execute(@NonNull CreateTariffActionArgument argument) {
        TariffType tariffType = tariffTypeService.getExisting(argument.tariffTypeId());

        return tariffService.create(CreateTariffArgument.builder()
                                                        .code(argument.code())
                                                        .tariffType(tariffType)
                                                        .paymentFrequency(argument.paymentFrequency())
                                                        .installmentAmount(argument.installmentAmount())
                                                        .installmentCount(argument.installmentCount())
                                                        .startBorder(argument.startBorder())
                                                        .endBorder(argument.endBorder())
                                                        .sale(argument.sale())
                                                        .cost(argument.cost())
                                                        .customPrice(argument.customPrice())
                                                        .build());
    }
}
