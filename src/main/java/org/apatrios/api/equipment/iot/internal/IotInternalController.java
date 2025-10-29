package org.apatrios.api.equipment.iot.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.equipment.iot.create.CreateIotActionArgument;
import org.apatrios.action.equipment.iot.update.UpdateIotActionArgument;
import org.apatrios.api.equipment.iot.internal.dto.IotDto;
import org.apatrios.api.equipment.iot.internal.dto.CreateIotDto;
import org.apatrios.api.equipment.iot.internal.dto.SearchIotDto;
import org.apatrios.api.equipment.iot.internal.dto.UpdateIotDto;
import org.apatrios.model.equipment.Iot;
import org.apatrios.service.equipment.iot.IotService;
import org.apatrios.service.equipment.iot.argument.SearchIotArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.equipment.iot.internal.mapper.IotMapper.IOT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/iot")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IotInternalController {

    IotService service;
    Action<CreateIotActionArgument, Iot> createIotAction;
    Action<UpdateIotActionArgument, Iot> updateIotAction;

    @PostMapping("create")
    public IotDto create(@Valid @RequestBody CreateIotDto dto) {
        return IOT_MAPPER.toDto(createIotAction.execute(IOT_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public IotDto update(@Valid @RequestBody UpdateIotDto dto) {
        return IOT_MAPPER.toDto(updateIotAction.execute(IOT_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("{id}")
    public IotDto get(@PathVariable UUID id) {
        return IOT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("list")
    public List<IotDto> list(SearchIotDto dto, Sort sort) {
        SearchIotArgument searchArgument = IOT_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(IOT_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<IotDto> page(SearchIotDto dto, Pageable pageable) {
        SearchIotArgument searchArgument = IOT_MAPPER.toSearchArgument(dto);
        return CollectionDto.of(service.page(searchArgument, pageable).map(IOT_MAPPER::toDto));
    }

    @DeleteMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}