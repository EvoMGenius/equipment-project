package org.apatrios.controller.dictionary.operator;

import lombok.RequiredArgsConstructor;
import org.apatrios.controller.dictionary.SimpleDictionaryController;
import org.apatrios.model.dictoinary.Operator;
import org.apatrios.service.dictionary.OperatorService;
import org.apatrios.service.dictionary.SimpleDictionaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("operator")
public class OperatorController extends SimpleDictionaryController<Operator> {

    private final OperatorService service;

    @Override
    protected SimpleDictionaryService<Operator> getService() {
        return this.service;
    }
}
