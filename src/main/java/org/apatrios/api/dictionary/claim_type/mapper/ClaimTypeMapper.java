package org.apatrios.api.dictionary.claim_type.mapper;

import org.apatrios.api.dictionary.claim_type.dto.ClaimTypeDto;
import org.apatrios.api.dictionary.claim_type.dto.SearchClaimTypeDto;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.model.dictoinary.ClaimType;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClaimTypeMapper extends BaseDictionaryMapper<ClaimType, ClaimTypeDto, SearchClaimTypeDto, BaseDictionarySearchArgument> {
}
