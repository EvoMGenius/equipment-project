package org.apatrios.api.dictionary.claim_type;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.claim_type.dto.ClaimTypeDto;
import org.apatrios.api.dictionary.claim_type.dto.SearchClaimTypeDto;
import org.apatrios.api.dictionary.claim_type.mapper.ClaimTypeMapper;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.model.dictoinary.ClaimType;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.ClaimTypeService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("claim-type")
public class ClaimTypeController extends BaseDictionaryController<ClaimType, BaseDictionarySearchArgument, SearchClaimTypeDto, ClaimTypeDto> {

    private final ClaimTypeService service;
    private final ClaimTypeMapper mapper;

    @Override
    protected BaseDictionaryService<ClaimType, BaseDictionarySearchArgument, ?> getService() {
        return this.service;
    }

    @Override
    protected BaseDictionaryMapper<ClaimType, ClaimTypeDto, SearchClaimTypeDto, BaseDictionarySearchArgument> getMapper() {
        return this.mapper;
    }
}
