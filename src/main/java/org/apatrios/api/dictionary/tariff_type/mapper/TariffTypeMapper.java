package org.apatrios.api.dictionary.tariff_type.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.tariff_type.dto.SearchTariffTypeDto;
import org.apatrios.api.dictionary.tariff_type.dto.TariffTypeDto;
import org.apatrios.model.dictoinary.TariffType;
import org.apatrios.service.dictionary.argument.SearchTariffTypeArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TariffTypeMapper extends BaseDictionaryMapper<TariffType, TariffTypeDto, SearchTariffTypeDto, SearchTariffTypeArgument>  {
}
