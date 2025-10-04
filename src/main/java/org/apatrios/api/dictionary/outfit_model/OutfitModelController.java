package org.apatrios.api.dictionary.outfit_model;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.outfit_model.dto.OutfitModelDto;
import org.apatrios.api.dictionary.outfit_model.dto.SearchOutfitModelDto;
import org.apatrios.api.dictionary.outfit_model.mapper.OutfitModelMapper;
import org.apatrios.model.dictoinary.OutfitModel;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.OutfitModelService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("outfit-model")
public class OutfitModelController extends BaseDictionaryController<OutfitModel, BaseDictionarySearchArgument, SearchOutfitModelDto, OutfitModelDto> {

    private final OutfitModelService service;

    private final OutfitModelMapper mapper;

    @Override
    protected BaseDictionaryService<OutfitModel, BaseDictionarySearchArgument, ?> getService() {
        return service;
    }

    @Override
    protected BaseDictionaryMapper<OutfitModel, OutfitModelDto, SearchOutfitModelDto, BaseDictionarySearchArgument> getMapper() {
        return mapper;
    }
}
