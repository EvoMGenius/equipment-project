package org.apatrios.api.dictionary.repair_type;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.dto.BaseDictionaryDto;
import org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto;
import org.apatrios.model.dictoinary.RepairType;
import org.apatrios.service.dictionary.RepairTypeService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("repair-type")
public class RepairTypeController extends BaseDictionaryController<RepairType, BaseDictionarySearchArgument, BaseDictionarySearchDto, BaseDictionaryDto> {

    private final RepairTypeService repairTypeService;

    @Override
    protected SimpleDictionaryService<RepairType> getService() {
        return this.repairTypeService;
    }
}
