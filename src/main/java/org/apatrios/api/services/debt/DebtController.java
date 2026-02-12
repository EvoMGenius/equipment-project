package org.apatrios.api.services.debt;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.services.debt.dto.DebtDto;
import org.apatrios.api.services.debt.dto.SearchDebtDto;
import org.apatrios.service.services.debt.DebtService;
import org.apatrios.service.services.debt.argument.SearchDebtArgument;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.apatrios.api.services.debt.mapper.DebtMapper.DEBT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service/debt")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DebtController {

    DebtService service;

    @GetMapping("{id}")
    public DebtDto get(@PathVariable UUID id) {
        return DEBT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public List<DebtDto> list(SearchDebtDto dto, Sort sort) {
        SearchDebtArgument searchArgument = DEBT_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(DEBT_MAPPER::toDto)
                      .toList();
    }
}