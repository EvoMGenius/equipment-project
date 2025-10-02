package org.apatrios.api.dictionary.service;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.dto.BaseDictionaryDto;
import org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto;
import org.apatrios.model.dictoinary.Service;
import org.apatrios.service.dictionary.ServiceService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("service")
public class ServiceController extends BaseDictionaryController<Service, BaseDictionarySearchArgument, BaseDictionarySearchDto, BaseDictionaryDto> {

    private final ServiceService serviceService;

    @Override
    protected SimpleDictionaryService<Service> getService() {
        return this.serviceService;
    }
}
