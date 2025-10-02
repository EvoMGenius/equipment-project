package org.apatrios.api.dictionary.repair_type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.repair_type.dto.RepairTypeDto;
import org.apatrios.api.dictionary.repair_type.dto.SearchRepairTypeDto;
import org.apatrios.model.dictoinary.RepairType;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("repair-type")
public class RepairTypeController extends BaseDictionaryController<RepairType, BaseDictionarySearchArgument, SearchRepairTypeDto, RepairTypeDto> {

    @Getter
    private final BaseDictionaryService<RepairType, BaseDictionarySearchArgument, ?> service;
    @Getter
    private final BaseDictionaryMapper<RepairType, RepairTypeDto, SearchRepairTypeDto, BaseDictionarySearchArgument> mapper;
}
