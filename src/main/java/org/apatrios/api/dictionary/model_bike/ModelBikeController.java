package org.apatrios.api.dictionary.model_bike;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.model_bike.dto.ModelBikeDto;
import org.apatrios.api.dictionary.model_bike.dto.SearchModelBikeDto;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("model-bike")
public class ModelBikeController extends BaseDictionaryController<ModelBike, BaseDictionarySearchArgument, SearchModelBikeDto, ModelBikeDto> {

    @Getter
    private final BaseDictionaryService<ModelBike, BaseDictionarySearchArgument, ?> service;
    @Getter
    private final BaseDictionaryMapper<ModelBike, ModelBikeDto, SearchModelBikeDto, BaseDictionarySearchArgument> mapper;
}
