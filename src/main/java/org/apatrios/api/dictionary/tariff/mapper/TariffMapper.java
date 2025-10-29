package org.apatrios.api.dictionary.tariff.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.tariff.dto.SearchTariffDto;
import org.apatrios.api.dictionary.tariff.dto.TariffDto;
import org.apatrios.model.dictoinary.Tariff;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TariffMapper extends BaseDictionaryMapper<Tariff, TariffDto, SearchTariffDto, BaseDictionarySearchArgument> {
}
