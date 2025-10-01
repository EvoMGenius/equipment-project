package org.apatrios.api.management.franchisee.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.management.franchisee.internal.dto.CreateFranchiseeDto;
import org.apatrios.api.management.franchisee.internal.dto.FranchiseeDto;
import org.apatrios.api.management.franchisee.internal.dto.SearchFranchiseeDto;
import org.apatrios.api.management.franchisee.internal.dto.UpdateFranchiseeDto;
import org.apatrios.service.management.franchisee.FranchiseeService;
import org.apatrios.service.management.franchisee.argument.SearchFranchiseeArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.management.franchisee.internal.mapper.FranchiseeMapper.FRANCHISEE_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/franchisee")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FranchiseeController {

    FranchiseeService service;

    @PostMapping("create")
    public FranchiseeDto create(@Valid @RequestBody CreateFranchiseeDto dto) {
        return FRANCHISEE_MAPPER.toDto(service.create(FRANCHISEE_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public FranchiseeDto update(@Valid @RequestBody UpdateFranchiseeDto dto) {
        return FRANCHISEE_MAPPER.toDto(service.update(dto.getId(), FRANCHISEE_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("list")
    public List<FranchiseeDto> list(SearchFranchiseeDto dto, Sort sort) {
        SearchFranchiseeArgument searchArgument = FRANCHISEE_MAPPER.toSearchArgument(dto);

        return service.list(searchArgument, sort)
                      .stream()
                      .map(FRANCHISEE_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<FranchiseeDto> page(SearchFranchiseeDto dto, Pageable pageable) {
        SearchFranchiseeArgument argument = FRANCHISEE_MAPPER.toSearchArgument(dto);

        Page<FranchiseeDto> dtoPage = service.page(argument, pageable)
                                             .map(FRANCHISEE_MAPPER::toDto);

        return CollectionDto.of(dtoPage);
    }

    @PostMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
