package org.apatrios.api.dictionary.point;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.dto.BaseDictionaryDto;
import org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto;
import org.apatrios.model.dictoinary.Point;
import org.apatrios.service.dictionary.PointService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("point")
public class PointController extends BaseDictionaryController<Point, BaseDictionarySearchArgument, BaseDictionarySearchDto, BaseDictionaryDto> {

    private final PointService service;

    @Override
    protected SimpleDictionaryService<Point> getService() {
        return this.service;
    }
}
