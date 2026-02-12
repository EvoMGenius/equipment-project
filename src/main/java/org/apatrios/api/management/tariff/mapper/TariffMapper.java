package org.apatrios.api.management.tariff.mapper;

import org.apatrios.action.management.tariff.create.CreateTariffActionArgument;
import org.apatrios.api.management.tariff.dto.CreateTariffDto;
import org.apatrios.api.management.tariff.dto.SearchTariffDto;
import org.apatrios.api.management.tariff.dto.TariffDto;
import org.apatrios.model.management.Tariff;
import org.apatrios.service.management.tariff.argument.SearchTariffArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TariffMapper {
    TariffMapper TARIFF_MAPPER = Mappers.getMapper(TariffMapper.class);

    CreateTariffActionArgument toCreateArgument(CreateTariffDto dto);
    SearchTariffArgument toSearchArgument(SearchTariffDto dto);
    TariffDto toDto(Tariff tariff);
}
