package org.apatrios.api.dictionary.point_type;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.PointType;
import org.apatrios.service.dictionary.PointTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("point-type")
public class PointTypeController extends org.apatrios.api.dictionary.BaseDictionaryController<PointType, org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument, org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto, org.apatrios.api.dictionary.common.dto.BaseDictionaryDto> {

    private final PointTypeService pointTypeService;

    @Override
    protected SimpleDictionaryService<PointType> getService() {
        return this.pointTypeService;
    }
}
