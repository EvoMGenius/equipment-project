package org.apatrios.controller.dictionary.component_model;

import lombok.RequiredArgsConstructor;
import org.apatrios.controller.dictionary.SimpleDictionaryController;
import org.apatrios.model.dictoinary.ComponentModel;
import org.apatrios.service.dictionary.ComponentModelService;
import org.apatrios.service.dictionary.SimpleDictionaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("component-model")
public class ComponentModelController extends SimpleDictionaryController<ComponentModel> {

    private final ComponentModelService service;

    @Override
    protected SimpleDictionaryService<ComponentModel> getService() {
        return this.service;
    }
}
