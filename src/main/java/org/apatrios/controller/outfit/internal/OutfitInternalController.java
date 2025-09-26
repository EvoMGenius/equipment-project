package org.apatrios.controller.outfit.internal;

import lombok.RequiredArgsConstructor;
import org.apatrios.controller.outfit.internal.dto.OutfitDto;
import org.apatrios.controller.outfit.internal.dto.CreateOutfitDto;
import org.apatrios.controller.outfit.internal.dto.SearchOutfitDto;
import org.apatrios.controller.outfit.internal.dto.UpdateOutfitDto;
import org.apatrios.service.outfit.OutfitService;
import org.apatrios.service.outfit.argument.CreateOutfitArgument;
import org.apatrios.service.outfit.argument.SearchOutfitArgument;
import org.apatrios.service.outfit.argument.UpdateOutfitArgument;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.apatrios.controller.outfit.internal.mapper.OutfitMapper.OUTFIT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/outfit")
public class OutfitInternalController {

    private final OutfitService service;

    @PostMapping("create")
    public OutfitDto create(@RequestBody CreateOutfitDto dto) {
        CreateOutfitArgument argument = OUTFIT_MAPPER.toCreateArgument(dto);
        return OUTFIT_MAPPER.toDto(service.create(argument));
    }

    @PutMapping("update/{id}")
    public OutfitDto update(@RequestBody UpdateOutfitDto dto, @PathVariable UUID id) {
        UpdateOutfitArgument argument = OUTFIT_MAPPER.toUpdateArgument(dto);
        return OUTFIT_MAPPER.toDto(service.update(id, argument));
    }

    @GetMapping("list")
    public List<OutfitDto> list(SearchOutfitDto dto, Sort sort) {
        SearchOutfitArgument searchArgument = OUTFIT_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(OUTFIT_MAPPER::toDto)
                      .toList();
    }
}