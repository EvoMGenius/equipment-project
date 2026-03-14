package org.apatrios.service.equipment.outfit.argument;

import lombok.Builder;
import org.apatrios.model.management.Tariff;

import java.util.List;

@Builder
public record CreateOutfitArgument(
        String name,
        List<Tariff> tariff,
        Tariff chosenTariff
) {
}