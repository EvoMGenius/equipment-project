package org.apatrios.api.dictionary.component_model;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.component_model.dto.ComponentModelDto;
import org.apatrios.api.dictionary.component_model.dto.SearchComponentModelDto;
import org.apatrios.api.dictionary.component_model.mapper.ComponentModelMapper;
import org.apatrios.model.dictoinary.ComponentModel;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.ComponentModelService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("component-model")
public class ComponentModelController extends BaseDictionaryController<ComponentModel, BaseDictionarySearchArgument, SearchComponentModelDto, ComponentModelDto> {

    private final ComponentModelService service;
    private final ComponentModelMapper mapper;

    @Override
    protected BaseDictionaryService<ComponentModel, BaseDictionarySearchArgument, ?> getService() {
        return service;
    }

    @Override
    protected BaseDictionaryMapper<ComponentModel, ComponentModelDto, SearchComponentModelDto, BaseDictionarySearchArgument> getMapper() {
        return mapper;
    }
}
