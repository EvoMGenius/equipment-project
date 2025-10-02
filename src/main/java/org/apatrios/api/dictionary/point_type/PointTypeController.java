package org.apatrios.api.dictionary.point_type;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.dto.BaseDictionaryDto;
import org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto;
import org.apatrios.model.dictoinary.PointType;
import org.apatrios.service.dictionary.PointTypeService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("point-type")
public class PointTypeController extends BaseDictionaryController<PointType, BaseDictionarySearchArgument, BaseDictionarySearchDto, BaseDictionaryDto> {

    private final PointTypeService pointTypeService;

    @Override
    protected SimpleDictionaryService<PointType> getService() {
        return this.pointTypeService;
    }
}
