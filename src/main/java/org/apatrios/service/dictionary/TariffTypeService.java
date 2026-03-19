package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.QTariffType;
import org.apatrios.model.dictoinary.TariffType;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.TariffTypeRepository;
import org.apatrios.service.dictionary.argument.SearchTariffTypeArgument;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TariffTypeService extends BaseDictionaryService<TariffType, SearchTariffTypeArgument, QTariffType> {

    private final TariffTypeRepository repository;

    @Override
    protected BaseDictionaryRepository<TariffType> getRepository() {
        return repository;
    }

    @Override
    protected QTariffType getQRoot() {
        return QTariffType.tariffType;
    }
}
