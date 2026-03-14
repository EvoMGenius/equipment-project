package org.apatrios.api.equipment.iot;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.equipment.iot.argument.CreateIotActionArgument;
import org.apatrios.api.equipment.iot.dto.CreateIotDto;
import org.apatrios.api.equipment.iot.dto.IotDto;
import org.apatrios.api.equipment.iot.dto.SearchIotDto;
import org.apatrios.model.equipment.Iot;
import org.apatrios.service.equipment.iot.IotService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.apatrios.api.equipment.iot.mapper.IotMapper.IOT_MAPPER;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/equip/iot")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IotController {

    Action<CreateIotActionArgument, Iot> createIotAction;
    IotService service;

    @PostMapping
    public IotDto create(@Valid @RequestBody CreateIotDto dto) {
        return IOT_MAPPER.toDto(createIotAction.execute(IOT_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public IotDto get(@PathVariable UUID id) {
        return IOT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public CollectionDto<IotDto> page(SearchIotDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(IOT_MAPPER.toSearchArgument(dto), pageable)
                                       .map(IOT_MAPPER::toDto));
    }
}