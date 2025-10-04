package org.apatrios.api.dictionary.point;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.point.dto.PointDto;
import org.apatrios.api.dictionary.point.dto.SearchPointDto;
import org.apatrios.api.dictionary.point.mapper.PointMapper;
import org.apatrios.model.dictoinary.Point;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.PointService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("point")
public class PointController extends BaseDictionaryController<Point, BaseDictionarySearchArgument, SearchPointDto, PointDto> {

    private final PointService service;

    private final PointMapper mapper;

    @Override
    protected BaseDictionaryService<Point, BaseDictionarySearchArgument, ?> getService() {
        return service;
    }

    @Override
    protected BaseDictionaryMapper<Point, PointDto, SearchPointDto, BaseDictionarySearchArgument> getMapper() {
        return mapper;
    }
}
