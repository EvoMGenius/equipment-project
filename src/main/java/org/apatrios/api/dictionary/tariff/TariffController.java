package org.apatrios.api.dictionary.tariff;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.tariff.dto.SearchTariffDto;
import org.apatrios.api.dictionary.tariff.dto.TariffDto;
import org.apatrios.api.dictionary.tariff.mapper.TariffMapper;
import org.apatrios.model.dictoinary.Tariff;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.TariffService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("tariff")
public class TariffController extends BaseDictionaryController<Tariff, BaseDictionarySearchArgument, SearchTariffDto, TariffDto> {

    private final TariffMapper mapper;
    private final TariffService service;

    @Override
    protected BaseDictionaryService<Tariff, BaseDictionarySearchArgument, ?> getService() {
        return this.service;
    }

    @Override
    protected BaseDictionaryMapper<Tariff, TariffDto, SearchTariffDto, BaseDictionarySearchArgument> getMapper() {
        return this.mapper;
    }
}
