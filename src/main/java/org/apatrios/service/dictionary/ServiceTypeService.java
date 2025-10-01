package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.model.dictoinary.QServiceType;
import org.apatrios.model.dictoinary.ServiceType;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.ServiceTypeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceTypeService extends BaseDictionaryService<ServiceType, org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument, QBaseDictionary> {

    private final ServiceTypeRepository repository;

    @Override
    protected BaseDictionaryRepository<ServiceType> getRepository() {
        return this.repository;
    }

    @Override
    protected QBaseDictionary getQRoot() {
        return QServiceType.serviceType._super;
    }
}
