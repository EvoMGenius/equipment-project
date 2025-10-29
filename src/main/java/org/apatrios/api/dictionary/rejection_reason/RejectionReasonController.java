package org.apatrios.api.dictionary.rejection_reason;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.rejection_reason.dto.RejectionReasonDto;
import org.apatrios.api.dictionary.rejection_reason.dto.SearchRejectionReasonDto;
import org.apatrios.api.dictionary.rejection_reason.mapper.RejectionReasonMapper;
import org.apatrios.model.dictoinary.RejectionReason;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.RejectionReasonService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("rejection-reason")
public class RejectionReasonController extends BaseDictionaryController<RejectionReason, BaseDictionarySearchArgument, SearchRejectionReasonDto, RejectionReasonDto> {

    private final RejectionReasonService service;
    private final RejectionReasonMapper mapper;

    @Override
    protected BaseDictionaryService<RejectionReason, BaseDictionarySearchArgument, ?> getService() {
        return this.service;
    }

    @Override
    protected BaseDictionaryMapper<RejectionReason, RejectionReasonDto, SearchRejectionReasonDto, BaseDictionarySearchArgument> getMapper() {
        return this.mapper;
    }
}
