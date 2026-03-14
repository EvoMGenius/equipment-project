package org.apatrios.api.management.company;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.management.company.dto.CreateCompanyDto;
import org.apatrios.api.management.company.dto.CompanyDto;
import org.apatrios.api.management.company.dto.SearchCompanyDto;
import org.apatrios.service.management.company.CompanyService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.apatrios.api.management.company.mapper.CompanyMapper.COMPANY_MAPPER;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/management/company")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CompanyController {

    CompanyService service;

    @PostMapping
    public CompanyDto create(@Valid @RequestBody CreateCompanyDto dto) {
        return COMPANY_MAPPER.toDto(service.create(COMPANY_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public CompanyDto get(@PathVariable UUID id) {
        return COMPANY_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public CollectionDto<CompanyDto> page(SearchCompanyDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(COMPANY_MAPPER.toSearchArgument(dto), pageable)
                                       .map(COMPANY_MAPPER::toDto));
    }
}