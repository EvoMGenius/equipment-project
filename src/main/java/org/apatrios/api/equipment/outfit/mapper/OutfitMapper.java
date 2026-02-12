package org.apatrios.api.equipment.outfit.mapper;

import org.apatrios.action.equipment.outfit.create.CreateOutfitActionArgument;
import org.apatrios.api.equipment.outfit.dto.OutfitDto;
import org.apatrios.api.equipment.outfit.dto.CreateOutfitDto;
import org.apatrios.api.equipment.outfit.dto.SearchOutfitDto;
import org.apatrios.model.equipment.Outfit;
import org.apatrios.service.equipment.outfit.argument.SearchOutfitArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OutfitMapper {
    OutfitMapper OUTFIT_MAPPER = Mappers.getMapper(OutfitMapper.class);

    SearchOutfitArgument toSearchArgument(SearchOutfitDto dto);
    OutfitDto toDto(Outfit outfit);
    CreateOutfitActionArgument toCreateArgument(CreateOutfitDto dto);
}