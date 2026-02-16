package org.apatrios.service.equipment.outfit.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.OutfitStatus;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class SearchOutfitArgument {
    String name;

    List<UUID> tariffIds;

    UUID chosenTariffId;

    OutfitStatus status;
}