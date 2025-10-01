package org.apatrios.api.dictionary.service;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.Service;
import org.apatrios.service.dictionary.ServiceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("service")
public class ServiceController extends org.apatrios.api.dictionary.BaseDictionaryController<Service, org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument, org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto, org.apatrios.api.dictionary.common.dto.BaseDictionaryDto> {

    private final ServiceService serviceService;

    @Override
    protected SimpleDictionaryService<Service> getService() {
        return this.serviceService;
    }
}
