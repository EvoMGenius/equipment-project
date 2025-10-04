package org.apatrios.api.dictionary.operator.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.operator.dto.OperatorDto;
import org.apatrios.api.dictionary.operator.dto.SearchOperatorDto;
import org.apatrios.model.dictoinary.Operator;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperatorMapper extends BaseDictionaryMapper<Operator, OperatorDto, SearchOperatorDto, BaseDictionarySearchArgument> {
}
