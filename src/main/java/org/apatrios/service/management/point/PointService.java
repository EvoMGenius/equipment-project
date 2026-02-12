package org.apatrios.service.management.point;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.Point;
import org.apatrios.model.management.QPoint;
import org.apatrios.repository.managment.PointRepository;
import org.apatrios.service.management.point.argument.CreatePointArgument;
import org.apatrios.service.management.point.argument.SearchPointArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository repository;
    private final QPoint qPoint = QPoint.point;

    @Transactional
    public Point create(@NonNull CreatePointArgument argument) {
        return repository.save(Point.builder()
                                    .pointType(argument.getPointType())
                                    .name(argument.getName())
                                    .number(argument.getNumber())
                                    .address(argument.getAddress())
                                    .workTime(argument.getWorkTime())
                                    .status(argument.getStatus())
                                    .build());
    }

    @Transactional(readOnly = true)
    public List<Point> list(@NonNull SearchPointArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    private Predicate buildPredicate(SearchPointArgument argument) {
        return QPredicates.builder()
                          .add(argument.getPointTypeId(), qPoint.pointType.id::eq)
                          .add(argument.getNumber(), qPoint.number::containsIgnoreCase)
                          .add(argument.getWorkTime(), qPoint.workTime::containsIgnoreCase)
                          .add(argument.getName(), qPoint.name::containsIgnoreCase)
                          .add(argument.getStatusId(), qPoint.status.id::eq)
                          .add(argument.getAddress(), qPoint.address::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Point getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Point.notFound"));
    }
}
