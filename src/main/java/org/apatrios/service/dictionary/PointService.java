package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.Point;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.model.dictoinary.QPoint;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.PointRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointService extends BaseDictionaryService<Point, org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument, QBaseDictionary> {

    private final PointRepository repository;

    @Override
    protected BaseDictionaryRepository<Point> getRepository() {
        return this.repository;
    }

    @Override
    protected QBaseDictionary getQRoot() {
        return QPoint.point._super;
    }
}
