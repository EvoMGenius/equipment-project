package org.apatrios.action.outfit.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.OutfitStatus;

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
