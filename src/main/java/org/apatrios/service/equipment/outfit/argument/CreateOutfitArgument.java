package org.apatrios.service.equipment.outfit.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.Tariff;

import java.util.List;

@Value
@Builder
public class CreateOutfitArgument {
    String name;

    List<Tariff> tariff;

    Tariff chosenTariff;
}