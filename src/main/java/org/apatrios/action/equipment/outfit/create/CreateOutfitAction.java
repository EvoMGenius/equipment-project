package org.apatrios.action.equipment.outfit.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.Status;
import org.apatrios.model.equipment.Outfit;
import org.apatrios.model.management.Tariff;
import org.apatrios.service.equipment.outfit.OutfitService;
import org.apatrios.service.equipment.outfit.argument.CreateOutfitArgument;
import org.apatrios.service.equipment.status.StatusService;
import org.apatrios.service.management.tariff.TariffService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateOutfitAction implements Action<CreateOutfitActionArgument, Outfit> {

    OutfitService outfitService;
    TariffService tariffService;
    StatusService statusService;

    @Override
    @Transactional
    public Outfit execute(@NonNull CreateOutfitActionArgument argument) {
        List<Tariff> tariffs = tariffService.getAllByIds(argument.getTariffIds());
        Tariff tariff = tariffService.getExisting(argument.getChosenTariffId());
        Status status = statusService.getExisting(argument.getStatusId());

        return outfitService.create(CreateOutfitArgument.builder()
                                                        .chosenTariff(tariff)
                                                        .name(argument.getName())
                                                        .status(status)
                                                        .tariff(tariffs)
                                                        .build());
    }
}
