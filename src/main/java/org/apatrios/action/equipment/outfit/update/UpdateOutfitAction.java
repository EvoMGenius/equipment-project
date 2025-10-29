package org.apatrios.action.equipment.outfit.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.Outfit;
import org.apatrios.model.dictoinary.OutfitModel;
import org.apatrios.model.management.Franchisee;
import org.apatrios.service.dictionary.OutfitModelService;
import org.apatrios.service.equipment.outfit.OutfitService;
import org.apatrios.service.equipment.outfit.argument.UpdateOutfitArgument;
import org.apatrios.service.management.franchisee.FranchiseeService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateOutfitAction implements Action<UpdateOutfitActionArgument, Outfit> {

    OutfitService outfitService;
    OutfitModelService outfitModelService;
    FranchiseeService franchiseeService;

    @Override
    @Transactional
    public Outfit execute(@NonNull UpdateOutfitActionArgument argument) {
        OutfitModel outfitModel = outfitModelService.getExisting(argument.getOutfitModelId());
        Franchisee franchisee = franchiseeService.getExisting(argument.getFranchiseeId());

        return outfitService.update(argument.getId(),
                                    UpdateOutfitArgument.builder()
                                                        .model(outfitModel)
                                                        .franchisee(franchisee)
                                                        .status(argument.getStatus())
                                                        .comment(argument.getComment())
                                                        .build());
    }
}
