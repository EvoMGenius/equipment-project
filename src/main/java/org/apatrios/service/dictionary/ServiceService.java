package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.model.dictoinary.QService;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.ServiceRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceService extends BaseDictionaryService<org.apatrios.model.dictoinary.Service, org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument, QBaseDictionary> {

    private final ServiceRepository repository;

    @Override
    protected BaseDictionaryRepository<org.apatrios.model.dictoinary.Service> getRepository() {
        return this.repository;
    }

    @Override
    protected QBaseDictionary getQRoot() {
        return QService.service._super;
    }
}
