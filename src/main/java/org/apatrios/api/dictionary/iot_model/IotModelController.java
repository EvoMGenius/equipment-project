package org.apatrios.api.dictionary.iot_model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.iot_model.dto.IotModelDto;
import org.apatrios.api.dictionary.iot_model.dto.SearchIotModelDto;
import org.apatrios.model.dictoinary.IotModel;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("iot-model")
public class IotModelController extends BaseDictionaryController<IotModel, BaseDictionarySearchArgument, SearchIotModelDto, IotModelDto> {

    @Getter
    private final BaseDictionaryService<IotModel, BaseDictionarySearchArgument, ?> service;
    @Getter
    private final BaseDictionaryMapper<IotModel, IotModelDto, SearchIotModelDto, BaseDictionarySearchArgument> mapper;
}
