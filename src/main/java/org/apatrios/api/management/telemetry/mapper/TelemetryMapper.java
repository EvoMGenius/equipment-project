package org.apatrios.api.management.telemetry.mapper;

import org.apatrios.api.management.telemetry.dto.SearchTelemetryDto;
import org.apatrios.api.management.telemetry.dto.TelemetryDto;
import org.apatrios.model.management.Telemetry;
import org.apatrios.service.management.telemetry.argument.SearchTelemetryArgument;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TelemetryMapper {
    TelemetryMapper TELEMETRY_MAPPER = Mappers.getMapper(TelemetryMapper.class);

    TelemetryDto toDto(Telemetry entity);
    SearchTelemetryArgument toSearchArgument(SearchTelemetryDto dto);
}