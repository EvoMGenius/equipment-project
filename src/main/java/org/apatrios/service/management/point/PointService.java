package org.apatrios.service.management.point;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.Point;
import org.apatrios.model.management.PointStatus;
import org.apatrios.model.management.QPoint;
import org.apatrios.repository.managment.PointRepository;
import org.apatrios.service.management.point.argument.CreatePointArgument;
import org.apatrios.service.management.point.argument.SearchPointArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                                    .status(PointStatus.CREATED)
                                    .build());
    }

    @Transactional(readOnly = true)
    public Page<Point> page(@NonNull SearchPointArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchPointArgument argument) {
        return QPredicates.builder()
                          .add(argument.getPointTypeId(), qPoint.pointType.id::eq)
                          .add(argument.getNumber(), qPoint.number::containsIgnoreCase)
                          .add(argument.getWorkTime(), qPoint.workTime::containsIgnoreCase)
                          .add(argument.getName(), qPoint.name::containsIgnoreCase)
                          .add(argument.getStatus(), qPoint.status::eq)
                          .add(argument.getAddress(), qPoint.address::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Point getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Point.notFound"));
    }
}
