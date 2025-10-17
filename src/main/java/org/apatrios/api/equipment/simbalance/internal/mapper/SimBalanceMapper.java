package org.apatrios.api.equipment.simbalance.internal.mapper;

import org.apatrios.action.equipment.sim_balance.create.CreateSimBalanceActionArgument;
import org.apatrios.action.equipment.sim_balance.update.UpdateSimBalanceActionArgument;
import org.apatrios.api.equipment.simbalance.internal.dto.SimBalanceDto;
import org.apatrios.api.equipment.simbalance.internal.dto.CreateSimBalanceDto;
import org.apatrios.api.equipment.simbalance.internal.dto.SearchSimBalanceDto;
import org.apatrios.api.equipment.simbalance.internal.dto.UpdateSimBalanceDto;
import org.apatrios.model.equipment.SimBalance;
import org.apatrios.service.equipment.sim_balance.argument.SearchSimBalanceArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SimBalanceMapper {
    SimBalanceMapper SIM_BALANCE_MAPPER = Mappers.getMapper(SimBalanceMapper.class);

    SearchSimBalanceArgument toSearchArgument(SearchSimBalanceDto dto);
    SimBalanceDto toDto(SimBalance simBalance);
    CreateSimBalanceActionArgument toCreateArgument(CreateSimBalanceDto dto);
    UpdateSimBalanceActionArgument toUpdateArgument(UpdateSimBalanceDto dto);
}