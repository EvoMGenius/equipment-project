package org.apatrios.api.dictionary.partner;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.partner.dto.PartnerDto;
import org.apatrios.api.dictionary.partner.dto.SearchPartnerDto;
import org.apatrios.api.dictionary.partner.mapper.PartnerMapper;
import org.apatrios.model.dictoinary.Partner;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.PartnerService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("partner")
public class PartnerController extends BaseDictionaryController<Partner, BaseDictionarySearchArgument, SearchPartnerDto, PartnerDto> {

    private final PartnerService service;

    private final PartnerMapper mapper;

    @Override
    protected BaseDictionaryService<Partner, BaseDictionarySearchArgument, ?> getService() {
        return this.service;
    }

    @Override
    protected BaseDictionaryMapper<Partner, PartnerDto, SearchPartnerDto, BaseDictionarySearchArgument> getMapper() {
        return this.mapper;
    }
}
