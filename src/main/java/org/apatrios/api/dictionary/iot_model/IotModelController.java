package org.apatrios.api.dictionary.iot_model;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.IotModel;
import org.apatrios.service.dictionary.IotModelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("iot-model")
public class IotModelController extends org.apatrios.api.dictionary.BaseDictionaryController<IotModel, org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument, org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto, org.apatrios.api.dictionary.common.dto.BaseDictionaryDto> {

    private final IotModelService iotModelService;

    @Override
    protected SimpleDictionaryService<IotModel> getService() {
        return this.iotModelService;
    }
}
