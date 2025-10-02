package org.apatrios.api.dictionary.operator;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.dto.BaseDictionaryDto;
import org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto;
import org.apatrios.model.dictoinary.Operator;
import org.apatrios.service.dictionary.OperatorService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("operator")
public class OperatorController extends BaseDictionaryController<Operator, BaseDictionarySearchArgument, BaseDictionarySearchDto, BaseDictionaryDto> {

    private final OperatorService service;

    @Override
    protected SimpleDictionaryService<Operator> getService() {
        return this.service;
    }
}
