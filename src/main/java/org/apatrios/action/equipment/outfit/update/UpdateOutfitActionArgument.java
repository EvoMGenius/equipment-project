package org.apatrios.action.equipment.outfit.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.OutfitStatus;

import java.util.UUID;

@Value
@Builder
public class UpdateOutfitActionArgument {
    UUID id;
    UUID outfitModelId;
    Integer invNumber;
    OutfitStatus status;
    String comment;
}
