package org.apatrios.api.dictionary.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.service.dto.SearchServiceDto;
import org.apatrios.api.dictionary.service.dto.ServiceDto;
import org.apatrios.model.dictoinary.Service;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("service")
public class ServiceController extends BaseDictionaryController<Service, BaseDictionarySearchArgument, SearchServiceDto, ServiceDto> {

    @Getter
    private final BaseDictionaryService<Service, BaseDictionarySearchArgument, ?> service;
    @Getter
    private final BaseDictionaryMapper<Service, ServiceDto, SearchServiceDto, BaseDictionarySearchArgument> mapper;
}
