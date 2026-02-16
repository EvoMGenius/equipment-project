package org.apatrios.api.services.contract.mapper;

import org.apatrios.api.services.contract.dto.ContractDto;
import org.apatrios.api.services.contract.dto.SearchContractDto;
import org.apatrios.service.services.contract.argument.SearchContractArgument;
import org.apatrios.model.services.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContractMapper {
    ContractMapper CONTRACT_MAPPER = Mappers.getMapper(ContractMapper.class);

    ContractDto toDto(Contract entity);
    SearchContractArgument toSearchArgument(SearchContractDto dto);
}