package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.PointType;
import org.apatrios.model.dictoinary.QPointType;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.PointTypeRepository;
import org.apatrios.service.dictionary.argument.SearchPointTypeArgument;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointTypeService extends BaseDictionaryService<PointType, SearchPointTypeArgument, QPointType> {

    private final PointTypeRepository repository;

    @Override
    protected BaseDictionaryRepository<PointType> getRepository() {
        return repository;
    }

    @Override
    protected QPointType getQRoot() {
        return QPointType.pointType;
    }
}
