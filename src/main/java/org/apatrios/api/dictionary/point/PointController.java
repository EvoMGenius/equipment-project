package org.apatrios.api.dictionary.point;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.Point;
import org.apatrios.service.dictionary.PointService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("point")
public class PointController extends org.apatrios.api.dictionary.BaseDictionaryController<Point, org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument, org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto, org.apatrios.api.dictionary.common.dto.BaseDictionaryDto> {

    private final PointService service;

    @Override
    protected SimpleDictionaryService<Point> getService() {
        return this.service;
    }
}
