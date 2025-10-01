package org.apatrios.api.equipment.outfit.internal.mapper;

import org.apatrios.action.equipment.outfit.create.CreateOutfitActionArgument;
import org.apatrios.action.equipment.outfit.update.UpdateOutfitActionArgument;
import org.apatrios.api.equipment.outfit.internal.dto.OutfitDto;
import org.apatrios.api.equipment.outfit.internal.dto.CreateOutfitDto;
import org.apatrios.api.equipment.outfit.internal.dto.SearchOutfitDto;
import org.apatrios.api.equipment.outfit.internal.dto.UpdateOutfitDto;
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
    UpdateOutfitActionArgument toUpdateArgument(UpdateOutfitDto dto);
}