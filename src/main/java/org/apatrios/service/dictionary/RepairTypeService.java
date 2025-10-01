package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.model.dictoinary.QRepairType;
import org.apatrios.model.dictoinary.RepairType;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.RepairTypeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RepairTypeService extends BaseDictionaryService<RepairType, org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument, QBaseDictionary> {

    private final RepairTypeRepository repository;

    @Override
    protected BaseDictionaryRepository<RepairType> getRepository() {
        return this.repository;
    }

    @Override
    protected QBaseDictionary getQRoot() {
        return QRepairType.repairType._super;
    }
}
