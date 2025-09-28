package org.apatrios.controller.dictionary.model_bike;

import lombok.RequiredArgsConstructor;
import org.apatrios.controller.dictionary.SimpleDictionaryController;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.service.dictionary.SimpleDictionaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("model-bike")
public class ModelBikeController extends SimpleDictionaryController<ModelBike> {

    private final SimpleDictionaryService<ModelBike> modelBikeService;

    @Override
    protected SimpleDictionaryService<ModelBike> getService() {
        return this.modelBikeService;
    }
}
