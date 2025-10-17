package org.apatrios.api.dictionary.service_dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.service_dictionary.dto.SearchServiceDictionaryDto;
import org.apatrios.api.dictionary.service_dictionary.dto.ServiceDictionaryDto;
import org.apatrios.api.dictionary.service_dictionary.mapper.ServiceDictionaryMapper;
import org.apatrios.model.dictoinary.ServiceDictionary;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.ServiceDictionaryService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("service")
public class ServiceDictionaryController extends BaseDictionaryController<ServiceDictionary, BaseDictionarySearchArgument, SearchServiceDictionaryDto, ServiceDictionaryDto> {

    private final ServiceDictionaryService service;

    private final ServiceDictionaryMapper mapper;

    @Override
    protected BaseDictionaryService<ServiceDictionary, BaseDictionarySearchArgument, ?> getService() {
        return service;
    }

    @Override
    protected BaseDictionaryMapper<ServiceDictionary, ServiceDictionaryDto, SearchServiceDictionaryDto, BaseDictionarySearchArgument> getMapper() {
        return mapper;
    }
}
