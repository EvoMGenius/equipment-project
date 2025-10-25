package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.model.dictoinary.QTariff;
import org.apatrios.model.dictoinary.Tariff;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.TariffRepository;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TariffService extends BaseDictionaryService<Tariff, BaseDictionarySearchArgument, QBaseDictionary>{

    private final TariffRepository repository;

    @Override
    protected BaseDictionaryRepository<Tariff> getRepository() {
        return this.repository;
    }

    @Override
    protected QBaseDictionary getQRoot() {
        return QTariff.tariff._super;
    }
}
