package org.apatrios.api.equipment.maintenance.internal.mapper;

import org.apatrios.api.equipment.maintenance.internal.dto.CreateMaintenanceDto;
import org.apatrios.api.equipment.maintenance.internal.dto.MaintenanceDto;
import org.apatrios.api.equipment.maintenance.internal.dto.SearchMaintenanceDto;
import org.apatrios.api.equipment.maintenance.internal.dto.UpdateMaintenanceDto;
import org.apatrios.model.equipment.Maintenance;
import org.apatrios.service.equipment.maintenance.argument.CreateMaintenanceArgument;
import org.apatrios.service.equipment.maintenance.argument.SearchMaintenanceArgument;
import org.apatrios.service.equipment.maintenance.argument.UpdateMaintenanceArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MaintenanceMapper {
    MaintenanceMapper MAINTENANCE_MAPPER = Mappers.getMapper(MaintenanceMapper.class);

    MaintenanceDto toDto(Maintenance maintenance);
    CreateMaintenanceArgument toCreateArgument(CreateMaintenanceDto dto);
    UpdateMaintenanceArgument toUpdateArgument(UpdateMaintenanceDto dto);
    SearchMaintenanceArgument toSearchArgument(SearchMaintenanceDto dto);
}
