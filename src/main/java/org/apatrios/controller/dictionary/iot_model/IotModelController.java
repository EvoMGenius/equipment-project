package org.apatrios.controller.dictionary.iot_model;

import lombok.RequiredArgsConstructor;
import org.apatrios.controller.dictionary.SimpleDictionaryController;
import org.apatrios.model.dictoinary.IotModel;
import org.apatrios.service.dictionary.IotModelService;
import org.apatrios.service.dictionary.SimpleDictionaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("iot-model")
public class IotModelController extends SimpleDictionaryController<IotModel> {

    private final IotModelService iotModelService;

    @Override
    protected SimpleDictionaryService<IotModel> getService() {
        return this.iotModelService;
    }
}
