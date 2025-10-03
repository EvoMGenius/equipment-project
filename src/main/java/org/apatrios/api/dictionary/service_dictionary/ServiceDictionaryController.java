package org.apatrios.api.dictionary.service_dictionary;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.service_dictionary.dto.SearchServiceDictionaryDto;
import org.apatrios.api.dictionary.service_dictionary.dto.ServiceDictionaryDto;
import org.apatrios.model.dictoinary.ServiceDictionary;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("service")
public class ServiceDictionaryController extends BaseDictionaryController<ServiceDictionary, BaseDictionarySearchArgument, SearchServiceDictionaryDto, ServiceDictionaryDto> {

    @Getter
    private final BaseDictionaryService<ServiceDictionary, BaseDictionarySearchArgument, ?> service;
    @Getter
    private final BaseDictionaryMapper<ServiceDictionary, ServiceDictionaryDto, SearchServiceDictionaryDto, BaseDictionarySearchArgument> mapper;
}
