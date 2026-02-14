package org.apatrios.api.services.photo;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.services.photo.dto.PhotoDto;
import org.apatrios.api.services.photo.dto.SearchPhotoDto;
import org.apatrios.service.services.photo.PhotoService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.apatrios.api.services.photo.mapper.PhotoMapper.PHOTO_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service/photo")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PhotoController {

    PhotoService service;

    @GetMapping("{id}")
    public PhotoDto get(@PathVariable UUID id) {
        return PHOTO_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public CollectionDto<PhotoDto> page(SearchPhotoDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(PHOTO_MAPPER.toSearchArgument(dto), pageable)
                                       .map(PHOTO_MAPPER::toDto));
    }
}