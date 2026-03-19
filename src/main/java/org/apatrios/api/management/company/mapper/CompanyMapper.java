package org.apatrios.api.management.company.mapper;

import org.apatrios.api.management.company.dto.CompanyDto;
import org.apatrios.api.management.company.dto.CreateCompanyDto;
import org.apatrios.api.management.company.dto.SearchCompanyDto;
import org.apatrios.model.management.Company;
import org.apatrios.service.management.company.argument.CreateCompanyArgument;
import org.apatrios.service.management.company.argument.SearchCompanyArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {
    CompanyMapper COMPANY_MAPPER = Mappers.getMapper(CompanyMapper.class);
    CompanyDto toDto(Company company);
    CreateCompanyArgument toCreateArgument(CreateCompanyDto dto);
    SearchCompanyArgument toSearchArgument(SearchCompanyDto dto);
}
