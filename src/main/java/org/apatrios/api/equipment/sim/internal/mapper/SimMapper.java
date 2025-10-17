package org.apatrios.api.equipment.sim.internal.mapper;

import org.apatrios.api.equipment.sim.internal.dto.SimDto;
import org.apatrios.api.equipment.sim.internal.dto.CreateSimDto;
import org.apatrios.api.equipment.sim.internal.dto.SearchSimDto;
import org.apatrios.api.equipment.sim.internal.dto.UpdateSimDto;
import org.apatrios.model.equipment.Sim;
import org.apatrios.service.equipment.sim.argument.CreateSimArgument;
import org.apatrios.service.equipment.sim.argument.SearchSimArgument;
import org.apatrios.service.equipment.sim.argument.UpdateSimArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SimMapper {
    SimMapper SIM_MAPPER = Mappers.getMapper(SimMapper.class);

    SearchSimArgument toSearchArgument(SearchSimDto dto);
    SimDto toDto(Sim sim);
    CreateSimArgument toCreateArgument(CreateSimDto dto);
    UpdateSimArgument toUpdateArgument(UpdateSimDto dto);
}