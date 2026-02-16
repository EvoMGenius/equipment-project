package org.apatrios.api.services.repair.mapper;

import org.apatrios.action.services.repair.create.CreateRepairActionArgument;
import org.apatrios.api.services.repair.dto.CreateRepairDto;
import org.apatrios.api.services.repair.dto.RepairDto;
import org.apatrios.api.services.repair.dto.SearchRepairDto;
import org.apatrios.model.services.Repair;
import org.apatrios.service.services.repair.argument.SearchRepairArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RepairMapper {
    RepairMapper REPAIR_MAPPER = Mappers.getMapper(RepairMapper.class);

    RepairDto toDto(Repair repair);
    CreateRepairActionArgument toCreateArgument(CreateRepairDto dto);
    SearchRepairArgument toSearchArgument(SearchRepairDto dto);
}
