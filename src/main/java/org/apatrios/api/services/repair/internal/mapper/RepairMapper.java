package org.apatrios.api.services.repair.internal.mapper;

import org.apatrios.action.services.repair.create.CreateRepairActionArgument;
import org.apatrios.action.services.repair.update.UpdateRepairActionArgument;
import org.apatrios.api.services.repair.internal.dto.CreateRepairDto;
import org.apatrios.api.services.repair.internal.dto.RepairDto;
import org.apatrios.api.services.repair.internal.dto.SearchRepairDto;
import org.apatrios.api.services.repair.internal.dto.UpdateRepairDto;
import org.apatrios.model.services.Repair;
import org.apatrios.service.services.repair.argument.SearchRepairArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RepairMapper {
    RepairMapper REPAIR_MAPPER = Mappers.getMapper(RepairMapper.class);

    RepairDto toDto(Repair repair);
    CreateRepairActionArgument toCreateArgument(CreateRepairDto dto);
    UpdateRepairActionArgument toUpdateArgument(UpdateRepairDto dto);
    SearchRepairArgument toSearchArgument(SearchRepairDto dto);
}
