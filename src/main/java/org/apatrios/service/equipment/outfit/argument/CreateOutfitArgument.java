package org.apatrios.service.equipment.outfit.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.OutfitModel;
import org.apatrios.model.management.Franchisee;

@Value
@Builder
public class CreateOutfitArgument {
    OutfitModel model;
    String comment;
    Franchisee franchisee;
}