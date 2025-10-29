package org.apatrios.action.equipment.outfit.create;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CreateOutfitActionArgument {
    UUID outfitModelId;
    String comment;
    UUID franchiseeId;
}
