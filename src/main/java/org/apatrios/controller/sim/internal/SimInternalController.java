package org.apatrios.controller.sim.internal;

import lombok.RequiredArgsConstructor;
import org.apatrios.controller.sim.internal.dto.SimDto;
import org.apatrios.controller.sim.internal.dto.CreateSimDto;
import org.apatrios.controller.sim.internal.dto.SearchSimDto;
import org.apatrios.controller.sim.internal.dto.UpdateSimDto;
import org.apatrios.service.sim.SimService;
import org.apatrios.service.sim.argument.CreateSimArgument;
import org.apatrios.service.sim.argument.SearchSimArgument;
import org.apatrios.service.sim.argument.UpdateSimArgument;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.apatrios.controller.sim.internal.mapper.SimMapper.SIM_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/sim")
public class SimInternalController {

    private final SimService service;

    @PostMapping("create")
    public SimDto create(@RequestBody CreateSimDto dto) {
        CreateSimArgument argument = SIM_MAPPER.toCreateArgument(dto);
        return SIM_MAPPER.toDto(service.create(argument));
    }

    @PutMapping("update/{id}")
    public SimDto update(@RequestBody UpdateSimDto dto, @PathVariable UUID id) {
        UpdateSimArgument argument = SIM_MAPPER.toUpdateArgument(dto);
        return SIM_MAPPER.toDto(service.update(id, argument));
    }

    @GetMapping("list")
    public List<SimDto> list(SearchSimDto dto, Sort sort) {
        SearchSimArgument searchArgument = SIM_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(SIM_MAPPER::toDto)
                      .toList();
    }
}