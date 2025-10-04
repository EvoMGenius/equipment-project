package org.apatrios.api.dictionary.iot_model.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.iot_model.dto.IotModelDto;
import org.apatrios.api.dictionary.iot_model.dto.SearchIotModelDto;
import org.apatrios.model.dictoinary.IotModel;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IotModelMapper extends BaseDictionaryMapper<IotModel, IotModelDto, SearchIotModelDto, BaseDictionarySearchArgument> {
}
