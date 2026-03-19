package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.IotModel;
import org.apatrios.model.dictoinary.QIotModel;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.IotModelRepository;
import org.apatrios.service.dictionary.argument.SearchIotModelArgument;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IotModelService extends BaseDictionaryService<IotModel, SearchIotModelArgument, QIotModel>{

    private final IotModelRepository repository;

    @Override
    protected BaseDictionaryRepository<IotModel> getRepository() {
        return repository;
    }

    @Override
    protected QIotModel getQRoot() {
        return QIotModel.iotModel;
    }
}
