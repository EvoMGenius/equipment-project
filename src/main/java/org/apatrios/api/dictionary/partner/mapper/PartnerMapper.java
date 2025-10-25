package org.apatrios.api.dictionary.partner.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.partner.dto.PartnerDto;
import org.apatrios.api.dictionary.partner.dto.SearchPartnerDto;
import org.apatrios.model.dictoinary.Partner;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PartnerMapper extends BaseDictionaryMapper<Partner, PartnerDto, SearchPartnerDto, BaseDictionarySearchArgument> {
}
