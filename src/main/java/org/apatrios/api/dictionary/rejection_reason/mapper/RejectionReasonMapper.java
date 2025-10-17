package org.apatrios.api.dictionary.rejection_reason.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.rejection_reason.dto.RejectionReasonDto;
import org.apatrios.api.dictionary.rejection_reason.dto.SearchRejectionReasonDto;
import org.apatrios.model.dictoinary.RejectionReason;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RejectionReasonMapper extends BaseDictionaryMapper<RejectionReason, RejectionReasonDto, SearchRejectionReasonDto, BaseDictionarySearchArgument> {
}
