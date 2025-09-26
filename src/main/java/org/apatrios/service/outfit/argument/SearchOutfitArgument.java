package org.apatrios.service.outfit.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.OutfitStatus;
import java.util.UUID;

@Value
@Builder
public class SearchOutfitArgument {
    UUID modelId;
    Integer invNumber;
    OutfitStatus status;
    String comment;
}