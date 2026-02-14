package org.apatrios.service.equipment.outfit.argument;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class SearchOutfitArgument {
    String name;

    List<UUID> tariffIds;

    UUID chosenTariffId;

    UUID statusId;
}