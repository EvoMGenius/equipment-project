package org.apatrios.api.services.repair.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.services.repair.create.CreateRepairActionArgument;
import org.apatrios.action.services.repair.update.UpdateRepairActionArgument;
import org.apatrios.api.services.repair.internal.dto.CreateRepairDto;
import org.apatrios.api.services.repair.internal.dto.RepairDto;
import org.apatrios.api.services.repair.internal.dto.SearchRepairDto;
import org.apatrios.api.services.repair.internal.dto.UpdateRepairDto;
import org.apatrios.model.services.Repair;
import org.apatrios.service.services.repair.RepairService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.services.repair.internal.mapper.RepairMapper.REPAIR_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/repair")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RepairController {

    RepairService service;
    Action<CreateRepairActionArgument, Repair> createRepairAction;
    Action<UpdateRepairActionArgument, Repair> updateRepairAction;

    @PostMapping("create")
    public RepairDto create(@Valid @RequestBody CreateRepairDto dto) {
        return REPAIR_MAPPER.toDto(createRepairAction.execute(REPAIR_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public RepairDto update(@Valid @RequestBody UpdateRepairDto dto) {
        return REPAIR_MAPPER.toDto(updateRepairAction.execute(REPAIR_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("list")
    public List<RepairDto> list(SearchRepairDto dto, Sort sort) {
        return service.list(REPAIR_MAPPER.toSearchArgument(dto), sort)
                      .stream()
                      .map(REPAIR_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<RepairDto> page(SearchRepairDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(REPAIR_MAPPER.toSearchArgument(dto), pageable)
                                       .map(REPAIR_MAPPER::toDto));
    }

    @PostMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
