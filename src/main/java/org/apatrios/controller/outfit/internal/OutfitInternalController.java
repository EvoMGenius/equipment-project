package org.apatrios.controller.outfit.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.outfit.create.CreateOutfitActionArgument;
import org.apatrios.action.outfit.update.UpdateOutfitActionArgument;
import org.apatrios.controller.outfit.internal.dto.OutfitDto;
import org.apatrios.controller.outfit.internal.dto.CreateOutfitDto;
import org.apatrios.controller.outfit.internal.dto.SearchOutfitDto;
import org.apatrios.controller.outfit.internal.dto.UpdateOutfitDto;
import org.apatrios.model.Outfit;
import org.apatrios.service.outfit.OutfitService;
import org.apatrios.service.outfit.argument.SearchOutfitArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.controller.outfit.internal.mapper.OutfitMapper.OUTFIT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/outfit")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OutfitInternalController {

    OutfitService service;
    Action<CreateOutfitActionArgument, Outfit> createOutfitAction;
    Action<UpdateOutfitActionArgument, Outfit> updateOutfitAction;

    @PostMapping("create")
    public OutfitDto create(@Valid @RequestBody CreateOutfitDto dto) {
        return OUTFIT_MAPPER.toDto(createOutfitAction.execute(OUTFIT_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public OutfitDto update(@Valid @RequestBody UpdateOutfitDto dto) {
        return OUTFIT_MAPPER.toDto(updateOutfitAction.execute(OUTFIT_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("list")
    public List<OutfitDto> list(SearchOutfitDto dto, Sort sort) {
        SearchOutfitArgument searchArgument = OUTFIT_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(OUTFIT_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<OutfitDto> page(SearchOutfitDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(OUTFIT_MAPPER.toSearchArgument(dto), pageable).map(OUTFIT_MAPPER::toDto));
    }

    @DeleteMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}