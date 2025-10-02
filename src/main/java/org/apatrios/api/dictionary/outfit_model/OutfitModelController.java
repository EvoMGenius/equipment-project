package org.apatrios.api.dictionary.outfit_model;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.dto.BaseDictionaryDto;
import org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto;
import org.apatrios.model.dictoinary.OutfitModel;
import org.apatrios.service.dictionary.OutfitModelService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("outfit-model")
public class OutfitModelController extends BaseDictionaryController<OutfitModel, BaseDictionarySearchArgument, BaseDictionarySearchDto, BaseDictionaryDto> {

    private final OutfitModelService service;

    @Override
    protected SimpleDictionaryService<OutfitModel> getService() {
        return this.service;
    }
}
