package org.apatrios.api.dictionary.tariff_type;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.tariff_type.dto.SearchTariffTypeDto;
import org.apatrios.api.dictionary.tariff_type.dto.TariffTypeDto;
import org.apatrios.api.dictionary.tariff_type.mapper.TariffTypeMapper;
import org.apatrios.model.dictoinary.TariffType;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.TariffTypeService;
import org.apatrios.service.dictionary.argument.SearchTariffTypeArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("dict/tariffType")
public class TariffTypeController extends BaseDictionaryController<TariffType, SearchTariffTypeArgument, SearchTariffTypeDto, TariffTypeDto> {

    private final TariffTypeService service;
    private final TariffTypeMapper mapper;

    @Override
    protected BaseDictionaryService<TariffType, SearchTariffTypeArgument, ?> getService() {
        return service;
    }

    @Override
    protected BaseDictionaryMapper<TariffType, TariffTypeDto, SearchTariffTypeDto, SearchTariffTypeArgument> getMapper() {
        return mapper;
    }
}
