package org.apatrios.controller.simbalance.internal;

import lombok.RequiredArgsConstructor;
import org.apatrios.controller.simbalance.internal.dto.SimBalanceDto;
import org.apatrios.controller.simbalance.internal.dto.CreateSimBalanceDto;
import org.apatrios.controller.simbalance.internal.dto.SearchSimBalanceDto;
import org.apatrios.controller.simbalance.internal.dto.UpdateSimBalanceDto;
import org.apatrios.service.simbalance.SimBalanceService;
import org.apatrios.service.simbalance.argument.CreateSimBalanceArgument;
import org.apatrios.service.simbalance.argument.SearchSimBalanceArgument;
import org.apatrios.service.simbalance.argument.UpdateSimBalanceArgument;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.apatrios.controller.simbalance.internal.mapper.SimBalanceMapper.SIM_BALANCE_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/simbalance")
public class SimBalanceInternalController {

    private final SimBalanceService service;

    @PostMapping("create")
    public SimBalanceDto create(@RequestBody CreateSimBalanceDto dto) {
        CreateSimBalanceArgument argument = SIM_BALANCE_MAPPER.toCreateArgument(dto);
        return SIM_BALANCE_MAPPER.toDto(service.create(argument));
    }

    @PutMapping("update/{id}")
    public SimBalanceDto update(@RequestBody UpdateSimBalanceDto dto, @PathVariable UUID id) {
        UpdateSimBalanceArgument argument = SIM_BALANCE_MAPPER.toUpdateArgument(dto);
        return SIM_BALANCE_MAPPER.toDto(service.update(id, argument));
    }

    @GetMapping("list")
    public List<SimBalanceDto> list(SearchSimBalanceDto dto, Sort sort) {
        SearchSimBalanceArgument searchArgument = SIM_BALANCE_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(SIM_BALANCE_MAPPER::toDto)
                      .toList();
    }
}