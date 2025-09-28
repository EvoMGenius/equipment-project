package org.apatrios.action.outfit.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.Outfit;
import org.apatrios.model.dictoinary.OutfitModel;
import org.apatrios.service.dictionary.OutfitModelService;
import org.apatrios.service.outfit.OutfitService;
import org.apatrios.service.outfit.argument.UpdateOutfitArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateOutfitAction implements Action<UpdateOutfitActionArgument, Outfit> {

    OutfitService outfitService;
    OutfitModelService outfitModelService;

    @Override
    @Transactional
    public Outfit execute(@NonNull UpdateOutfitActionArgument argument) {
        OutfitModel outfitModel = outfitModelService.getExisting(argument.getOutfitModelId());

        return outfitService.update(argument.getId(),
                                    UpdateOutfitArgument.builder()
                                                        .model(outfitModel)
                                                        .invNumber(argument.getInvNumber())
                                                        .status(argument.getStatus())
                                                        .comment(argument.getComment())
                                                        .build());
    }
}
