package org.apatrios.api.equipment.maintenance.internal;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.equipment.maintenance.internal.dto.CreateMaintenanceDto;
import org.apatrios.api.equipment.maintenance.internal.dto.MaintenanceDto;
import org.apatrios.api.equipment.maintenance.internal.dto.SearchMaintenanceDto;
import org.apatrios.api.equipment.maintenance.internal.dto.UpdateMaintenanceDto;
import org.apatrios.service.equipment.maintenance.MaintenanceService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.equipment.maintenance.internal.mapper.MaintenanceMapper.MAINTENANCE_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/maintenance")
public class MaintenanceController {

    private final MaintenanceService service;

    @PostMapping("create")
    public MaintenanceDto create(@Valid @RequestBody CreateMaintenanceDto dto) {
        return MAINTENANCE_MAPPER.toDto(service.create(MAINTENANCE_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public MaintenanceDto update(@Valid @RequestBody UpdateMaintenanceDto dto) {
        return MAINTENANCE_MAPPER.toDto(service.update(dto.getId(), MAINTENANCE_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("{id}")
    public MaintenanceDto get(@PathVariable UUID id) {
        return MAINTENANCE_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("list")
    public List<MaintenanceDto> list(SearchMaintenanceDto dto, Sort sort) {
        return service.list(MAINTENANCE_MAPPER.toSearchArgument(dto), sort)
                      .stream()
                      .map(MAINTENANCE_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<MaintenanceDto> page(SearchMaintenanceDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(MAINTENANCE_MAPPER.toSearchArgument(dto), pageable).map(MAINTENANCE_MAPPER::toDto));
    }

    @DeleteMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
