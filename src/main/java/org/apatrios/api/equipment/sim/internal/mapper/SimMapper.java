package org.apatrios.api.equipment.sim.internal.mapper;

import org.apatrios.action.equipment.sim.create.CreateSimActionArgument;
import org.apatrios.action.equipment.sim.update.UpdateSimActionArgument;
import org.apatrios.api.equipment.sim.internal.dto.SimDto;
import org.apatrios.api.equipment.sim.internal.dto.CreateSimDto;
import org.apatrios.api.equipment.sim.internal.dto.SearchSimDto;
import org.apatrios.api.equipment.sim.internal.dto.UpdateSimDto;
import org.apatrios.model.equipment.Sim;
import org.apatrios.service.equipment.sim.argument.SearchSimArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SimMapper {
    SimMapper SIM_MAPPER = Mappers.getMapper(SimMapper.class);

    SearchSimArgument toSearchArgument(SearchSimDto dto);
    SimDto toDto(Sim sim);
    CreateSimActionArgument toCreateArgument(CreateSimDto dto);
    UpdateSimActionArgument toUpdateArgument(UpdateSimDto dto);
}