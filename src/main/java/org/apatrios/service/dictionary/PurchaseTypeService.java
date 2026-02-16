package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.PurchaseType;
import org.apatrios.model.dictoinary.QPurchaseType;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.PurchaseTypeRepository;
import org.apatrios.service.dictionary.argument.SearchPurchaseTypeArgument;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseTypeService extends BaseDictionaryService<PurchaseType, SearchPurchaseTypeArgument, QPurchaseType>{

    private final PurchaseTypeRepository repository;

    @Override
    protected BaseDictionaryRepository<PurchaseType> getRepository() {
        return repository;
    }

    @Override
    protected QPurchaseType getQRoot() {
        return QPurchaseType.purchaseType;
    }
}
