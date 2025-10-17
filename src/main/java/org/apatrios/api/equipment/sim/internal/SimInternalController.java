package org.apatrios.api.equipment.sim.internal;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.equipment.sim.internal.dto.SimDto;
import org.apatrios.api.equipment.sim.internal.dto.CreateSimDto;
import org.apatrios.api.equipment.sim.internal.dto.SearchSimDto;
import org.apatrios.api.equipment.sim.internal.dto.UpdateSimDto;
import org.apatrios.service.equipment.sim.SimService;
import org.apatrios.service.equipment.sim.argument.SearchSimArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.equipment.sim.internal.mapper.SimMapper.SIM_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/sim")
public class SimInternalController {

    private final SimService service;

    @PostMapping("create")
    public SimDto create(@Valid @RequestBody CreateSimDto dto) {
        return SIM_MAPPER.toDto(service.create(SIM_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public SimDto update(@Valid @RequestBody UpdateSimDto dto) {
        return SIM_MAPPER.toDto(service.update(dto.getId(), SIM_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("list")
    public List<SimDto> list(SearchSimDto dto, Sort sort) {
        SearchSimArgument searchArgument = SIM_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(SIM_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<SimDto> page(SearchSimDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(SIM_MAPPER.toSearchArgument(dto), pageable).map(SIM_MAPPER::toDto));
    }

    @DeleteMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}