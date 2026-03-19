package org.apatrios.action.equipment.outfit.argument;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record CreateOutfitActionArgument(
        String name,
        List<UUID> tariffIds,
        UUID chosenTariffId
) {
}
