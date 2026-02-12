package org.apatrios.api.services.repair;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.services.repair.create.CreateRepairActionArgument;
import org.apatrios.api.services.repair.dto.CreateRepairDto;
import org.apatrios.api.services.repair.dto.RepairDto;
import org.apatrios.api.services.repair.dto.SearchRepairDto;
import org.apatrios.model.services.Repair;
import org.apatrios.service.services.repair.RepairService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.services.repair.mapper.RepairMapper.REPAIR_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service/repair")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RepairController {

    RepairService service;
    Action<CreateRepairActionArgument, Repair> createRepairAction;

    @PostMapping
    public RepairDto create(@Valid @RequestBody CreateRepairDto dto) {
        return REPAIR_MAPPER.toDto(createRepairAction.execute(REPAIR_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public RepairDto get(@PathVariable UUID id) {
        return REPAIR_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public List<RepairDto> list(SearchRepairDto dto, Sort sort) {
        return service.list(REPAIR_MAPPER.toSearchArgument(dto), sort)
                      .stream()
                      .map(REPAIR_MAPPER::toDto)
                      .toList();
    }
}
