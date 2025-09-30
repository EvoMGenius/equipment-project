package org.apatrios.controller.sim.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.sim.create.CreateSimActionArgument;
import org.apatrios.action.sim.update.UpdateSimActionArgument;
import org.apatrios.controller.sim.internal.dto.SimDto;
import org.apatrios.controller.sim.internal.dto.CreateSimDto;
import org.apatrios.controller.sim.internal.dto.SearchSimDto;
import org.apatrios.controller.sim.internal.dto.UpdateSimDto;
import org.apatrios.model.Sim;
import org.apatrios.service.sim.SimService;
import org.apatrios.service.sim.argument.SearchSimArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.controller.sim.internal.mapper.SimMapper.SIM_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/sim")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SimInternalController {

    SimService service;
    Action<CreateSimActionArgument, Sim> createSimAction;
    Action<UpdateSimActionArgument, Sim> updateSimAction;

    @PostMapping("create")
    public SimDto create(@Valid @RequestBody CreateSimDto dto) {
        return SIM_MAPPER.toDto(createSimAction.execute(SIM_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public SimDto update(@Valid @RequestBody UpdateSimDto dto) {
        return SIM_MAPPER.toDto(updateSimAction.execute(SIM_MAPPER.toUpdateArgument(dto)));
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