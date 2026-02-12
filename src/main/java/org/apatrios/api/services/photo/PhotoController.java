package org.apatrios.api.services.photo;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.services.photo.dto.PhotoDto;
import org.apatrios.api.services.photo.dto.CreatePhotoDto;
import org.apatrios.api.services.photo.dto.SearchPhotoDto;
import org.apatrios.service.services.photo.PhotoService;
import org.apatrios.service.services.photo.argument.SearchPhotoArgument;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.services.photo.mapper.PhotoMapper.PHOTO_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service/photo")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PhotoController {

    PhotoService service;

    @PostMapping
    public PhotoDto create(@Valid @RequestBody CreatePhotoDto dto) {
        return PHOTO_MAPPER.toDto(service.create(PHOTO_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public PhotoDto get(@PathVariable UUID id) {
        return PHOTO_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public List<PhotoDto> list(SearchPhotoDto dto, Sort sort) {
        SearchPhotoArgument searchArgument = PHOTO_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(PHOTO_MAPPER::toDto)
                      .toList();
    }
}