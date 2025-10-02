package org.apatrios.api.dictionary.point;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.iot_model.dto.IotModelDto;
import org.apatrios.api.dictionary.iot_model.dto.SearchIotModelDto;
import org.apatrios.api.dictionary.point.dto.PointDto;
import org.apatrios.api.dictionary.point.dto.SearchPointDto;
import org.apatrios.model.dictoinary.IotModel;
import org.apatrios.model.dictoinary.Point;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("point")
public class PointController extends BaseDictionaryController<Point, BaseDictionarySearchArgument, SearchPointDto, PointDto> {

    @Getter
    private final BaseDictionaryService<Point, BaseDictionarySearchArgument, ?> service;
    @Getter
    private final BaseDictionaryMapper<Point, PointDto, SearchPointDto, BaseDictionarySearchArgument> mapper;
}
