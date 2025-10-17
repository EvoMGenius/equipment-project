package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.IotModel;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.model.dictoinary.QIotModel;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.IotModelRepository;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IotModelService extends BaseDictionaryService<IotModel, BaseDictionarySearchArgument, QBaseDictionary> {

    private final IotModelRepository repository;

    @Override
    protected BaseDictionaryRepository<IotModel> getRepository() {
        return this.repository;
    }

    @Override
    protected QBaseDictionary getQRoot() {
        return QIotModel.iotModel._super;
    }
}
