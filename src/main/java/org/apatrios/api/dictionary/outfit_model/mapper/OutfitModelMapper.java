package org.apatrios.api.dictionary.outfit_model.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.outfit_model.dto.OutfitModelDto;
import org.apatrios.api.dictionary.outfit_model.dto.SearchOutfitModelDto;
import org.apatrios.model.dictoinary.OutfitModel;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OutfitModelMapper extends BaseDictionaryMapper<OutfitModel, OutfitModelDto, SearchOutfitModelDto, BaseDictionarySearchArgument> {
}
