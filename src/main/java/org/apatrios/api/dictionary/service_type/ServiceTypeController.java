package org.apatrios.api.dictionary.service_type;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.ServiceType;
import org.apatrios.service.dictionary.ServiceTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("service-type")
public class ServiceTypeController extends org.apatrios.api.dictionary.BaseDictionaryController<ServiceType, org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument, org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto, org.apatrios.api.dictionary.common.dto.BaseDictionaryDto> {

    private final ServiceTypeService serviceTypeService;

    @Override
    protected SimpleDictionaryService<ServiceType> getService() {
        return this.serviceTypeService;
    }
}
