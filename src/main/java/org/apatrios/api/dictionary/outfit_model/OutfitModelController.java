package org.apatrios.api.dictionary.outfit_model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.outfit_model.dto.OutfitModelDto;
import org.apatrios.api.dictionary.outfit_model.dto.SearchOutfitModelDto;
import org.apatrios.model.dictoinary.OutfitModel;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("outfit-model")
public class OutfitModelController extends BaseDictionaryController<OutfitModel, BaseDictionarySearchArgument, SearchOutfitModelDto, OutfitModelDto> {

    @Getter
    private final BaseDictionaryService<OutfitModel, BaseDictionarySearchArgument, ?> service;
    @Getter
    private final BaseDictionaryMapper<OutfitModel, OutfitModelDto, SearchOutfitModelDto, BaseDictionarySearchArgument> mapper;
}
