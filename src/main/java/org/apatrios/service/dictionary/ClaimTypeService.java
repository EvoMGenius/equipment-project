package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.ClaimType;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.model.dictoinary.QClaimType;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.ClaimTypeRepository;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClaimTypeService extends BaseDictionaryService<ClaimType, BaseDictionarySearchArgument, QBaseDictionary> {

    private final ClaimTypeRepository repository;

    @Override
    protected BaseDictionaryRepository<ClaimType> getRepository() {
        return this.repository;
    }

    @Override
    protected QBaseDictionary getQRoot() {
        return QClaimType.claimType._super;
    }
}
