package org.apatrios.controller.simbalance.internal.mapper;

import org.apatrios.controller.simbalance.internal.dto.SimBalanceDto;
import org.apatrios.controller.simbalance.internal.dto.CreateSimBalanceDto;
import org.apatrios.controller.simbalance.internal.dto.SearchSimBalanceDto;
import org.apatrios.controller.simbalance.internal.dto.UpdateSimBalanceDto;
import org.apatrios.model.SimBalance;
import org.apatrios.service.simbalance.argument.CreateSimBalanceArgument;
import org.apatrios.service.simbalance.argument.SearchSimBalanceArgument;
import org.apatrios.service.simbalance.argument.UpdateSimBalanceArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SimBalanceMapper {
    SimBalanceMapper SIM_BALANCE_MAPPER = Mappers.getMapper(SimBalanceMapper.class);

    SearchSimBalanceArgument toSearchArgument(SearchSimBalanceDto dto);
    SimBalanceDto toDto(SimBalance simBalance);
    CreateSimBalanceArgument toCreateArgument(CreateSimBalanceDto dto);
    UpdateSimBalanceArgument toUpdateArgument(UpdateSimBalanceDto dto);
}