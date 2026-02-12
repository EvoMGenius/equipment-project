package org.apatrios.api.services.contract;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.services.contract.dto.ContractDto;
import org.apatrios.api.services.contract.dto.SearchContractDto;
import org.apatrios.service.services.contract.ContractService;
import org.apatrios.service.services.contract.argument.SearchContractArgument;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.apatrios.api.services.contract.mapper.ContractMapper.CONTRACT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service/contract")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ContractController {

    ContractService service;

    @GetMapping("{id}")
    public ContractDto get(@PathVariable UUID id) {
        return CONTRACT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public List<ContractDto> list(SearchContractDto dto, Sort sort) {
        SearchContractArgument searchArgument = CONTRACT_MAPPER.toSearchArgument(dto);
        return service.list(searchArgument, sort)
                      .stream()
                      .map(CONTRACT_MAPPER::toDto)
                      .toList();
    }
}