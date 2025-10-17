package org.apatrios.service.equipment.outfit.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.OutfitStatus;
import java.util.UUID;

@Value
@Builder
public class SearchOutfitArgument {
    UUID modelId;
    Integer invNumber;
    OutfitStatus status;
    String comment;
}