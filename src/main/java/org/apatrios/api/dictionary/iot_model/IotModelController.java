package org.apatrios.api.dictionary.iot_model;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.dto.BaseDictionaryDto;
import org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto;
import org.apatrios.model.dictoinary.IotModel;
import org.apatrios.service.dictionary.IotModelService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("iot-model")
public class IotModelController extends BaseDictionaryController<IotModel, BaseDictionarySearchArgument, BaseDictionarySearchDto, BaseDictionaryDto> {

    private final IotModelService iotModelService;

    @Override
    protected SimpleDictionaryService<IotModel> getService() {
        return this.iotModelService;
    }
}
