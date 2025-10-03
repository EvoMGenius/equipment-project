package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.model.dictoinary.QServiceDictionary;
import org.apatrios.model.dictoinary.ServiceDictionary;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.ServiceDictionaryRepository;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceDictionaryService extends BaseDictionaryService<ServiceDictionary, BaseDictionarySearchArgument, QBaseDictionary> {

    private final ServiceDictionaryRepository repository;

    @Override
    protected BaseDictionaryRepository<ServiceDictionary> getRepository() {
        return this.repository;
    }

    @Override
    protected QBaseDictionary getQRoot() {
        return QServiceDictionary.serviceDictionary._super;
    }
}
