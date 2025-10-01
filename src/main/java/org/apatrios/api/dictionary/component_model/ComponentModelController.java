package org.apatrios.api.dictionary.component_model;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.ComponentModel;
import org.apatrios.service.dictionary.ComponentModelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("component-model")
public class ComponentModelController extends org.apatrios.api.dictionary.BaseDictionaryController<ComponentModel, org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument, org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto, org.apatrios.api.dictionary.common.dto.BaseDictionaryDto> {

    private final ComponentModelService service;

    @Override
    protected SimpleDictionaryService<ComponentModel> getService() {
        return this.service;
    }
}
