package org.apatrios.api.management.telemetry;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.management.telemetry.dto.SearchTelemetryDto;
import org.apatrios.api.management.telemetry.dto.TelemetryDto;
import org.apatrios.service.management.telemetry.TelemetryService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.apatrios.api.management.telemetry.mapper.TelemetryMapper.TELEMETRY_MAPPER;

@RestController
@RequestMapping("/management/telemetry")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TelemetryController {

    TelemetryService service;

    @GetMapping("/{id}")
    public TelemetryDto get(@PathVariable UUID id) {
        return TELEMETRY_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public CollectionDto<TelemetryDto> page(SearchTelemetryDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(TELEMETRY_MAPPER.toSearchArgument(dto), pageable)
                                       .map(TELEMETRY_MAPPER::toDto));
    }
}