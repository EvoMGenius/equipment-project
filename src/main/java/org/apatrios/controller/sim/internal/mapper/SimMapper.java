package org.apatrios.controller.sim.internal.mapper;

import org.apatrios.controller.sim.internal.dto.SimDto;
import org.apatrios.controller.sim.internal.dto.CreateSimDto;
import org.apatrios.controller.sim.internal.dto.SearchSimDto;
import org.apatrios.controller.sim.internal.dto.UpdateSimDto;
import org.apatrios.model.Sim;
import org.apatrios.service.sim.argument.CreateSimArgument;
import org.apatrios.service.sim.argument.SearchSimArgument;
import org.apatrios.service.sim.argument.UpdateSimArgument;
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