package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.Operator;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.model.dictoinary.QOperator;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.OperatorRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperatorService extends BaseDictionaryService<Operator, org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument, QBaseDictionary> {

    private final OperatorRepository repository;

    @Override
    protected BaseDictionaryRepository<Operator> getRepository() {
        return this.repository;
    }

    @Override
    protected QBaseDictionary getQRoot() {
        return QOperator.operator._super;
    }
}
