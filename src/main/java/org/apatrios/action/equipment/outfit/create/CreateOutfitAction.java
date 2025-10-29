package org.apatrios.action.equipment.outfit.create;

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
import org.apatrios.service.equipment.outfit.argument.CreateOutfitArgument;
import org.apatrios.service.management.franchisee.FranchiseeService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateOutfitAction implements Action<CreateOutfitActionArgument, Outfit> {

    OutfitService outfitService;
    OutfitModelService outfitModelService;
    FranchiseeService franchiseeService;

    @Override
    @Transactional
    public Outfit execute(@NonNull CreateOutfitActionArgument argument) {
        OutfitModel outfitModel = outfitModelService.getExisting(argument.getOutfitModelId());
        Franchisee franchisee = franchiseeService.getExisting(argument.getFranchiseeId());

        return outfitService.create(CreateOutfitArgument.builder()
                                                        .model(outfitModel)
                                                        .franchisee(franchisee)
                                                        .comment(argument.getComment())
                                                        .build());
    }
}
