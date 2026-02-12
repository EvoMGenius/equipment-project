package org.apatrios.api.equipment.status;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.equipment.status.dto.StatusDto;
import org.apatrios.api.equipment.status.dto.CreateStatusDto;
import org.apatrios.api.equipment.status.dto.SearchStatusDto;
import org.apatrios.service.equipment.status.StatusService;
import org.apatrios.service.equipment.status.argument.SearchStatusArgument;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.equipment.status.mapper.StatusMapper.STATUS_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equip/status")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StatusController {

    StatusService service;

    @PostMapping
    public StatusDto create(@Valid @RequestBody CreateStatusDto dto) {
        return STATUS_MAPPER.toDto(service.create(STATUS_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public StatusDto get(@PathVariable UUID id) {
        return STATUS_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public List<StatusDto> list(SearchStatusDto dto, Sort sort) {
        SearchStatusArgument searchArgument = STATUS_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(STATUS_MAPPER::toDto)
                      .toList();
    }
}