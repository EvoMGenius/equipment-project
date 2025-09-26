package org.apatrios.controller.iot.internal;

import lombok.RequiredArgsConstructor;
import org.apatrios.controller.iot.internal.dto.IotDto;
import org.apatrios.controller.iot.internal.dto.CreateIotDto;
import org.apatrios.controller.iot.internal.dto.SearchIotDto;
import org.apatrios.controller.iot.internal.dto.UpdateIotDto;
import org.apatrios.service.iot.IotService;
import org.apatrios.service.iot.argument.CreateIotArgument;
import org.apatrios.service.iot.argument.SearchIotArgument;
import org.apatrios.service.iot.argument.UpdateIotArgument;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.apatrios.controller.iot.internal.mapper.IotMapper.IOT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/iot")
public class IotInternalController {

    private final IotService service;

    @PostMapping("create")
    public IotDto create(@RequestBody CreateIotDto dto) {
        CreateIotArgument argument = IOT_MAPPER.toCreateArgument(dto);
        return IOT_MAPPER.toDto(service.create(argument));
    }

    @PutMapping("update/{id}")
    public IotDto update(@RequestBody UpdateIotDto dto, @PathVariable UUID id) {
        UpdateIotArgument argument = IOT_MAPPER.toUpdateArgument(dto);
        return IOT_MAPPER.toDto(service.update(id, argument));
    }

    @GetMapping("list")
    public List<IotDto> list(SearchIotDto dto, Sort sort) {
        SearchIotArgument searchArgument = IOT_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(IOT_MAPPER::toDto)
                      .toList();
    }
}