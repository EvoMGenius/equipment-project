package org.apatrios.api.services.debt.mapper;

import org.apatrios.api.services.debt.dto.DebtDto;
import org.apatrios.api.services.debt.dto.SearchDebtDto;
import org.apatrios.service.services.debt.argument.SearchDebtArgument;
import org.apatrios.model.services.Debt;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DebtMapper {
    DebtMapper DEBT_MAPPER = Mappers.getMapper(DebtMapper.class);

    DebtDto toDto(Debt entity);
    SearchDebtArgument toSearchArgument(SearchDebtDto dto);
}