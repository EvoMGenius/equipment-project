package org.apatrios.api.dictionary.point_type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.point_type.dto.PointTypeDto;
import org.apatrios.api.dictionary.point_type.dto.SearchPointTypeDto;
import org.apatrios.model.dictoinary.PointType;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("point-type")
public class PointTypeController extends BaseDictionaryController<PointType, BaseDictionarySearchArgument, SearchPointTypeDto, PointTypeDto> {

    @Getter
    private final BaseDictionaryService<PointType, BaseDictionarySearchArgument, ?> service;
    @Getter
    private final BaseDictionaryMapper<PointType, PointTypeDto, SearchPointTypeDto, BaseDictionarySearchArgument> mapper;
}
