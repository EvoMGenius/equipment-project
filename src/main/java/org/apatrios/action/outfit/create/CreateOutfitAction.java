package org.apatrios.action.outfit.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.Outfit;
import org.apatrios.model.dictoinary.OutfitModel;
import org.apatrios.service.dictionary.OutfitModelService;
import org.apatrios.service.outfit.OutfitService;
import org.apatrios.service.outfit.argument.CreateOutfitArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateOutfitAction implements Action<CreateOutfitActionArgument, Outfit> {

    OutfitService outfitService;
    OutfitModelService outfitModelService;

    @Override
    @Transactional
    public Outfit execute(@NonNull CreateOutfitActionArgument argument) {
        OutfitModel outfitModel = outfitModelService.getExisting(argument.getOutfitModelId());

        return outfitService.create(CreateOutfitArgument.builder()
                                                        .model(outfitModel)
                                                        .invNumber(argument.getInvNumber())
                                                        .comment(argument.getComment())
                                                        .build());
    }
}
