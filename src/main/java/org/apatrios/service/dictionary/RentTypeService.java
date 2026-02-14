package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.QRentType;
import org.apatrios.model.dictoinary.RentType;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.RentTypeRepository;
import org.apatrios.service.dictionary.argument.SearchRentTypeArgument;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentTypeService extends BaseDictionaryService<RentType, SearchRentTypeArgument, QRentType>{

    private final RentTypeRepository repository;

    @Override
    protected BaseDictionaryRepository<RentType> getRepository() {
        return repository;
    }

    @Override
    protected QRentType getQRoot() {
        return QRentType.rentType;
    }
}
