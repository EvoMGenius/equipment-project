package org.apatrios.api.dictionary.component_model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.component_model.dto.ComponentModelDto;
import org.apatrios.api.dictionary.component_model.dto.SearchComponentModelDto;
import org.apatrios.model.dictoinary.ComponentModel;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("component-model")
public class ComponentModelController extends BaseDictionaryController<ComponentModel, BaseDictionarySearchArgument, SearchComponentModelDto, ComponentModelDto> {

    @Getter
    private final BaseDictionaryService<ComponentModel, BaseDictionarySearchArgument, ?> service;
    @Getter
    private final BaseDictionaryMapper<ComponentModel, ComponentModelDto, SearchComponentModelDto, BaseDictionarySearchArgument> mapper;

}
