package org.apatrios.service.outfit.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.OutfitModel;

@Value
@Builder
public class CreateOutfitArgument {
    OutfitModel model;
    Integer invNumber;
    String comment;
}