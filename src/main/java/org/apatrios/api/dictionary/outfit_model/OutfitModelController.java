package org.apatrios.api.dictionary.outfit_model;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.OutfitModel;
import org.apatrios.service.dictionary.OutfitModelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("outfit-model")
public class OutfitModelController extends org.apatrios.api.dictionary.BaseDictionaryController<OutfitModel, org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument, org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto, org.apatrios.api.dictionary.common.dto.BaseDictionaryDto> {

    private final OutfitModelService service;

    @Override
    protected SimpleDictionaryService<OutfitModel> getService() {
        return this.service;
    }
}
