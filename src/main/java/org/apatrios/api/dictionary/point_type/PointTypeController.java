package org.apatrios.api.dictionary.point_type;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.point_type.dto.PointTypeDto;
import org.apatrios.api.dictionary.point_type.dto.SearchPointTypeDto;
import org.apatrios.api.dictionary.point_type.mapper.PointTypeMapper;
import org.apatrios.model.dictoinary.PointType;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.PointTypeService;
import org.apatrios.service.dictionary.argument.SearchPointTypeArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("dict/pointType")
public class PointTypeController extends BaseDictionaryController<PointType, SearchPointTypeArgument, SearchPointTypeDto, PointTypeDto> {

    private final PointTypeService service;
    private final PointTypeMapper mapper;

    @Override
    protected BaseDictionaryService<PointType, SearchPointTypeArgument, ?> getService() {
        return service;
    }

    @Override
    protected BaseDictionaryMapper<PointType, PointTypeDto, SearchPointTypeDto, SearchPointTypeArgument> getMapper() {
        return mapper;
    }
}
