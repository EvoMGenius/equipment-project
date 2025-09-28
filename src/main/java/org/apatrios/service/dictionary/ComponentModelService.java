package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.QComponent;
import org.apatrios.model.dictoinary.ComponentModel;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.model.dictoinary.QComponentModel;
import org.apatrios.repository.dictionary.ComponentModelRepository;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComponentModelService extends SimpleDictionaryService<ComponentModel> {

    private final ComponentModelRepository repository;

    @Override
    protected BaseDictionaryRepository<ComponentModel> getRepository() {
        return this.repository;
    }

    @Override
    protected QBaseDictionary getQRoot() {
        return QComponentModel.componentModel._super;
    }
}
