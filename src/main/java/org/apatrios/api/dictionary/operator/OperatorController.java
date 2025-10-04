package org.apatrios.api.dictionary.operator;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.operator.dto.OperatorDto;
import org.apatrios.api.dictionary.operator.dto.SearchOperatorDto;
import org.apatrios.api.dictionary.operator.mapper.OperatorMapper;
import org.apatrios.model.dictoinary.Operator;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.OperatorService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("operator")
public class OperatorController extends BaseDictionaryController<Operator, BaseDictionarySearchArgument, SearchOperatorDto, OperatorDto> {


    private final OperatorService service;

    private final OperatorMapper mapper;

    @Override
    protected BaseDictionaryService<Operator, BaseDictionarySearchArgument, ?> getService() {
        return service;
    }

    @Override
    protected BaseDictionaryMapper<Operator, OperatorDto, SearchOperatorDto, BaseDictionarySearchArgument> getMapper() {
        return mapper;
    }
}
