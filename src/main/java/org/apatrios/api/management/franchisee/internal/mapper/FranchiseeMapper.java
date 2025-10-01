package org.apatrios.api.management.franchisee.internal.mapper;

import org.apatrios.api.management.franchisee.internal.dto.CreateFranchiseeDto;
import org.apatrios.api.management.franchisee.internal.dto.FranchiseeDto;
import org.apatrios.api.management.franchisee.internal.dto.SearchFranchiseeDto;
import org.apatrios.api.management.franchisee.internal.dto.UpdateFranchiseeDto;
import org.apatrios.model.management.Franchisee;
import org.apatrios.service.management.franchisee.argument.CreateFranchiseeArgument;
import org.apatrios.service.management.franchisee.argument.SearchFranchiseeArgument;
import org.apatrios.service.management.franchisee.argument.UpdateFranchiseeArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FranchiseeMapper {
    FranchiseeMapper FRANCHISEE_MAPPER = Mappers.getMapper(FranchiseeMapper.class);

    FranchiseeDto toDto(Franchisee franchisee);
    CreateFranchiseeArgument toCreateArgument(CreateFranchiseeDto dto);
    UpdateFranchiseeArgument toUpdateArgument(UpdateFranchiseeDto dto);
    SearchFranchiseeArgument toSearchArgument(SearchFranchiseeDto dto);
}
