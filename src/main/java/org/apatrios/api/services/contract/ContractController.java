package org.apatrios.api.services.contract;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.services.contract.dto.ContractDto;
import org.apatrios.api.services.contract.dto.SearchContractDto;
import org.apatrios.service.services.contract.ContractService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    public CollectionDto<ContractDto> page(SearchContractDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(CONTRACT_MAPPER.toSearchArgument(dto), pageable)
                                       .map(CONTRACT_MAPPER::toDto));
    }
}