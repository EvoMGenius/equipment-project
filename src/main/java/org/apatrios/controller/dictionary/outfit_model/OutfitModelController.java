package org.apatrios.controller.dictionary.outfit_model;

import lombok.RequiredArgsConstructor;
import org.apatrios.controller.dictionary.SimpleDictionaryController;
import org.apatrios.model.dictoinary.OutfitModel;
import org.apatrios.service.dictionary.OutfitModelService;
import org.apatrios.service.dictionary.SimpleDictionaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("outfit-model")
public class OutfitModelController extends SimpleDictionaryController<OutfitModel> {

    private final OutfitModelService service;

    @Override
    protected SimpleDictionaryService<OutfitModel> getService() {
        return this.service;
    }
}
