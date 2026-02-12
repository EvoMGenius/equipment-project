package org.apatrios.api.services.photo.mapper;

import org.apatrios.api.services.photo.dto.PhotoDto;
import org.apatrios.api.services.photo.dto.CreatePhotoDto;
import org.apatrios.api.services.photo.dto.SearchPhotoDto;
import org.apatrios.model.services.Photo;
import org.apatrios.service.services.photo.argument.CreatePhotoArgument;
import org.apatrios.service.services.photo.argument.SearchPhotoArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhotoMapper {
    PhotoMapper PHOTO_MAPPER = Mappers.getMapper(PhotoMapper.class);

    PhotoDto toDto(Photo entity);
    CreatePhotoArgument toCreateArgument(CreatePhotoDto dto);
    SearchPhotoArgument toSearchArgument(SearchPhotoDto dto);
}