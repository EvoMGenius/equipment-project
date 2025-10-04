package org.apatrios.api.dictionary.service_type;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.service_type.dto.SearchServiceTypeDto;
import org.apatrios.api.dictionary.service_type.dto.ServiceTypeDto;
import org.apatrios.api.dictionary.service_type.mapper.ServiceTypeMapper;
import org.apatrios.model.dictoinary.ServiceType;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.ServiceTypeService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("service-type")
public class ServiceTypeController extends BaseDictionaryController<ServiceType, BaseDictionarySearchArgument, SearchServiceTypeDto, ServiceTypeDto> {

    private final ServiceTypeService service;

    private final ServiceTypeMapper mapper;

    @Override
    protected BaseDictionaryService<ServiceType, BaseDictionarySearchArgument, ?> getService() {
        return service;
    }

    @Override
    protected BaseDictionaryMapper<ServiceType, ServiceTypeDto, SearchServiceTypeDto, BaseDictionarySearchArgument> getMapper() {
        return mapper;
    }
}
