package org.apatrios.service.services.repair;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.QRepair;
import org.apatrios.model.services.Repair;
import org.apatrios.repository.services.RepairRepository;
import org.apatrios.service.services.repair.argument.CreateRepairArgument;
import org.apatrios.service.services.repair.argument.SearchRepairArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RepairService {

    private final RepairRepository repository;
    private final QRepair qRepair = QRepair.repair;

    @Transactional
    public Repair create(@NonNull CreateRepairArgument argument) {
        return repository.save(Repair.builder()
                                     .point(argument.getPoint())
                                     .fixType(argument.getFixType())
                                     .photos(argument.getPhotos())
                                     .problem(argument.getProblem())
                                     .number(argument.getNumber())
                                     .createDate(LocalDateTime.now())
                                     .status(argument.getStatus())
                                     .build());
    }

    @Transactional(readOnly = true)
    public Page<Repair> page(@NonNull SearchRepairArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchRepairArgument argument) {
        return QPredicates.builder()
                          .add(argument.getProblem(), qRepair.problem::containsIgnoreCase)
                          .add(argument.getNumber(), qRepair.number::containsIgnoreCase)
                          .add(argument.getFixTypeId(), qRepair.fixType.id::eq)
                          .add(argument.getPhotoIds(), qRepair.photos.any().id::in)
                          .add(argument.getStatusId(), qRepair.status.id::eq)
                          .add(argument.getCreateDateTo(), qRepair.createDate::loe)
                          .add(argument.getCreateDateFrom(), qRepair.createDate::goe)
                          .add(argument.getPointId(), qRepair.point.id::eq)
                          .addAnyString(argument.getSearchString(), qRepair.number::containsIgnoreCase, qRepair.problem::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Repair getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Repair.notFound"));
    }
}
