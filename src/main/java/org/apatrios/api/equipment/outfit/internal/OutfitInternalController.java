package org.apatrios.api.equipment.outfit.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.equipment.outfit.create.CreateOutfitActionArgument;
import org.apatrios.api.equipment.outfit.internal.dto.OutfitDto;
import org.apatrios.api.equipment.outfit.internal.dto.CreateOutfitDto;
import org.apatrios.api.equipment.outfit.internal.dto.SearchOutfitDto;
import org.apatrios.model.equipment.Outfit;
import org.apatrios.service.equipment.outfit.OutfitService;
import org.apatrios.service.equipment.outfit.argument.SearchOutfitArgument;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.equipment.outfit.internal.mapper.OutfitMapper.OUTFIT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equip/outfit")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OutfitInternalController {

    OutfitService service;
    Action<CreateOutfitActionArgument, Outfit> createOutfitAction;

    @PostMapping
    public OutfitDto create(@Valid @RequestBody CreateOutfitDto dto) {
        return OUTFIT_MAPPER.toDto(createOutfitAction.execute(OUTFIT_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public OutfitDto get(@PathVariable UUID id) {
        return OUTFIT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public List<OutfitDto> list(SearchOutfitDto dto, Sort sort) {
        SearchOutfitArgument searchArgument = OUTFIT_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(OUTFIT_MAPPER::toDto)
                      .toList();
    }
}