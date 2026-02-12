package org.apatrios.api.services.support;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.services.support.create.CreateSupportActionArgument;
import org.apatrios.api.services.support.dto.SupportDto;
import org.apatrios.api.services.support.dto.CreateSupportDto;
import org.apatrios.api.services.support.dto.SearchSupportDto;
import org.apatrios.model.services.Support;
import org.apatrios.service.services.support.SupportService;
import org.apatrios.service.services.support.argument.SearchSupportArgument;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.services.support.mapper.SupportMapper.SUPPORT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service/support")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SupportController {

    SupportService service;
    Action<CreateSupportActionArgument, Support> createSupportAction;

    @PostMapping
    public SupportDto create(@Valid @RequestBody CreateSupportDto dto) {
        return SUPPORT_MAPPER.toDto(createSupportAction.execute(SUPPORT_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public SupportDto get(@PathVariable UUID id) {
        return SUPPORT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public List<SupportDto> list(SearchSupportDto dto, Sort sort) {
        SearchSupportArgument searchArgument = SUPPORT_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(SUPPORT_MAPPER::toDto)
                      .toList();
    }
}