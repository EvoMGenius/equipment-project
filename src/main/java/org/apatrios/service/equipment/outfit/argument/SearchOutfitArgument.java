package org.apatrios.service.equipment.outfit.argument;

import lombok.Builder;
import org.apatrios.model.equipment.OutfitStatus;

import java.util.List;
import java.util.UUID;

@Builder
public record SearchOutfitArgument(
        String name,
        List<UUID> tariffIds,
        UUID chosenTariffId,
        OutfitStatus status
) {
}