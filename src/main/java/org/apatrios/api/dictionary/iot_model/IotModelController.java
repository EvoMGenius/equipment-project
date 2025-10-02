package org.apatrios.api.dictionary.iot_model;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.dto.BaseDictionaryDto;
import org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.component_model.dto.ComponentModelDto;
import org.apatrios.api.dictionary.component_model.dto.SearchComponentModelDto;
import org.apatrios.api.dictionary.iot_model.dto.IotModelDto;
import org.apatrios.api.dictionary.iot_model.dto.SearchIotModelDto;
import org.apatrios.model.dictoinary.ComponentModel;
import org.apatrios.model.dictoinary.IotModel;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.IotModelService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("iot-model")
public class IotModelController extends BaseDictionaryController<IotModel, BaseDictionarySearchArgument, SearchIotModelDto, IotModelDto> {

    private final BaseDictionaryService<IotModel, BaseDictionarySearchArgument, ?> service;
    private final BaseDictionaryMapper<IotModel, IotModelDto, SearchIotModelDto, BaseDictionarySearchArgument> mapper;

    @Override
    protected BaseDictionaryService<IotModel, BaseDictionarySearchArgument, ?> getService() {
        return service;
    }

    @Override
    protected BaseDictionaryMapper<IotModel, IotModelDto, SearchIotModelDto, BaseDictionarySearchArgument> getMapper() {
        return mapper;
    }
}
