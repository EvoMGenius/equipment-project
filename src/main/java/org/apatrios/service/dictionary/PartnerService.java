package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.Partner;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.model.dictoinary.QPartner;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.PartnerRepository;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartnerService extends BaseDictionaryService<Partner, BaseDictionarySearchArgument, QBaseDictionary>{

    private final PartnerRepository repository;

    @Override
    protected BaseDictionaryRepository<Partner> getRepository() {
        return this.repository;
    }

    @Override
    protected QBaseDictionary getQRoot() {
        return QPartner.partner._super;
    }
}
