package org.apatrios.controller.simbalance.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.sim_balance.create.CreateSimBalanceActionArgument;
import org.apatrios.action.sim_balance.update.UpdateSimBalanceActionArgument;
import org.apatrios.controller.simbalance.internal.dto.SimBalanceDto;
import org.apatrios.controller.simbalance.internal.dto.CreateSimBalanceDto;
import org.apatrios.controller.simbalance.internal.dto.SearchSimBalanceDto;
import org.apatrios.controller.simbalance.internal.dto.UpdateSimBalanceDto;
import org.apatrios.model.SimBalance;
import org.apatrios.service.sim_balance.SimBalanceService;
import org.apatrios.service.sim_balance.argument.SearchSimBalanceArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.controller.simbalance.internal.mapper.SimBalanceMapper.SIM_BALANCE_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/simbalance")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SimBalanceInternalController {

    SimBalanceService service;
    Action<CreateSimBalanceActionArgument, SimBalance> createSimBalanceAction;
    Action<UpdateSimBalanceActionArgument, SimBalance> updateSimBalanceAction;

    @PostMapping("create")
    public SimBalanceDto create(@Valid @RequestBody CreateSimBalanceDto dto) {
        return SIM_BALANCE_MAPPER.toDto(createSimBalanceAction.execute(SIM_BALANCE_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public SimBalanceDto update(@Valid @RequestBody UpdateSimBalanceDto dto) {
        return SIM_BALANCE_MAPPER.toDto(updateSimBalanceAction.execute(SIM_BALANCE_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("list")
    public List<SimBalanceDto> list(SearchSimBalanceDto dto, Sort sort) {
        SearchSimBalanceArgument searchArgument = SIM_BALANCE_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(SIM_BALANCE_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<SimBalanceDto> page(SearchSimBalanceDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(SIM_BALANCE_MAPPER.toSearchArgument(dto), pageable).map(SIM_BALANCE_MAPPER::toDto));
    }

    @DeleteMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}