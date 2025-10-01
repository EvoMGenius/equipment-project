package org.apatrios.api.dictionary.operator;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.Operator;
import org.apatrios.service.dictionary.OperatorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("operator")
public class OperatorController extends org.apatrios.api.dictionary.BaseDictionaryController<Operator, org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument, org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto, org.apatrios.api.dictionary.common.dto.BaseDictionaryDto> {

    private final OperatorService service;

    @Override
    protected SimpleDictionaryService<Operator> getService() {
        return this.service;
    }
}
