package org.apatrios.controller.dictionary.modelbike;

import lombok.RequiredArgsConstructor;
import org.apatrios.controller.dictionary.DictionaryController;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.service.dictionary.DictionaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("model-bike")
public class ModelBikeController extends DictionaryController<ModelBike> {

    private final DictionaryService<ModelBike> modelBikeService;

    @Override
    protected DictionaryService<ModelBike> getService() {
        return this.modelBikeService;
    }
}
