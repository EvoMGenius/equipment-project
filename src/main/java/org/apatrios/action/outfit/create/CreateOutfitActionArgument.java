package org.apatrios.action.outfit.create;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CreateOutfitActionArgument {
    UUID outfitModelId;
    Integer invNumber;
    String comment;
}
