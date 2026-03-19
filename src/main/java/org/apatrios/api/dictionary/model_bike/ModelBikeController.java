package org.apatrios.api.dictionary.model_bike;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.model_bike.dto.ModelBikeDto;
import org.apatrios.api.dictionary.model_bike.dto.SearchModelBikeDto;
import org.apatrios.api.dictionary.model_bike.mapper.ModelBikeMapper;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.ModelBikeService;
import org.apatrios.service.dictionary.argument.SearchModelBikeArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("dict/model-bike")
public class ModelBikeController extends BaseDictionaryController<ModelBike, SearchModelBikeArgument, SearchModelBikeDto, ModelBikeDto> {

    private final ModelBikeService service;
    private final ModelBikeMapper mapper;

    @Override
    protected BaseDictionaryService<ModelBike, SearchModelBikeArgument, ?> getService() {
        return service;
    }

    @Override
    protected BaseDictionaryMapper<ModelBike, ModelBikeDto, SearchModelBikeDto, SearchModelBikeArgument> getMapper() {
        return mapper;
    }
}
