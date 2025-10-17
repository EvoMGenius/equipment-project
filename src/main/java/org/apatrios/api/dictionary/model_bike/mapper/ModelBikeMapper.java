package org.apatrios.api.dictionary.model_bike.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.model_bike.dto.ModelBikeDto;
import org.apatrios.api.dictionary.model_bike.dto.SearchModelBikeDto;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelBikeMapper extends BaseDictionaryMapper<ModelBike, ModelBikeDto, SearchModelBikeDto, BaseDictionarySearchArgument> {
}
