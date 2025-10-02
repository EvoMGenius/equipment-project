package org.apatrios.api.dictionary.service_type;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.dto.BaseDictionaryDto;
import org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto;
import org.apatrios.model.dictoinary.ServiceType;
import org.apatrios.service.dictionary.ServiceTypeService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("service-type")
public class ServiceTypeController extends BaseDictionaryController<ServiceType, BaseDictionarySearchArgument, BaseDictionarySearchDto, BaseDictionaryDto> {

    private final ServiceTypeService serviceTypeService;

    @Override
    protected SimpleDictionaryService<ServiceType> getService() {
        return this.serviceTypeService;
    }
}
