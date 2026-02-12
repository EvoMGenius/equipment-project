package org.apatrios.api.management.tariff;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.tariff.create.CreateTariffActionArgument;
import org.apatrios.api.management.tariff.dto.CreateTariffDto;
import org.apatrios.api.management.tariff.dto.SearchTariffDto;
import org.apatrios.api.management.tariff.dto.TariffDto;
import org.apatrios.model.management.Tariff;
import org.apatrios.service.management.tariff.TariffService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.management.tariff.mapper.TariffMapper.TARIFF_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management/tariff")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TariffController {

    TariffService service;
    Action<CreateTariffActionArgument, Tariff> createTariffAction;

    @PostMapping
    public TariffDto create(@Valid @RequestBody CreateTariffDto dto) {
        return TARIFF_MAPPER.toDto(createTariffAction.execute(TARIFF_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public TariffDto get(@PathVariable UUID id) {
        return TARIFF_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public List<TariffDto> list(SearchTariffDto dto, Sort sort) {
        return service.list(TARIFF_MAPPER.toSearchArgument(dto), sort)
                      .stream()
                      .map(TARIFF_MAPPER::toDto)
                      .toList();
    }
}