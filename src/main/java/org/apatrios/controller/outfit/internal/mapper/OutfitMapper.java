package org.apatrios.controller.outfit.internal.mapper;

import org.apatrios.action.outfit.create.CreateOutfitActionArgument;
import org.apatrios.action.outfit.update.UpdateOutfitActionArgument;
import org.apatrios.controller.outfit.internal.dto.OutfitDto;
import org.apatrios.controller.outfit.internal.dto.CreateOutfitDto;
import org.apatrios.controller.outfit.internal.dto.SearchOutfitDto;
import org.apatrios.controller.outfit.internal.dto.UpdateOutfitDto;
import org.apatrios.model.Outfit;
import org.apatrios.service.outfit.argument.SearchOutfitArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OutfitMapper {
    OutfitMapper OUTFIT_MAPPER = Mappers.getMapper(OutfitMapper.class);

    SearchOutfitArgument toSearchArgument(SearchOutfitDto dto);
    OutfitDto toDto(Outfit outfit);
    CreateOutfitActionArgument toCreateArgument(CreateOutfitDto dto);
    UpdateOutfitActionArgument toUpdateArgument(UpdateOutfitDto dto);
}