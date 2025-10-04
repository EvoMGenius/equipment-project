package org.apatrios.api.dictionary.repair_type.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.repair_type.dto.RepairTypeDto;
import org.apatrios.api.dictionary.repair_type.dto.SearchRepairTypeDto;
import org.apatrios.model.dictoinary.RepairType;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RepairTypeMapper extends BaseDictionaryMapper<RepairType, RepairTypeDto, SearchRepairTypeDto, BaseDictionarySearchArgument> {
}
