package org.apatrios.action.equipment.outfit.create;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class CreateOutfitActionArgument {
    String name;
    List<UUID> tariffIds;
    UUID chosenTariffId;
    UUID statusId;
}
