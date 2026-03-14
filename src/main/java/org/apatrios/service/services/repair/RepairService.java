package org.apatrios.service.services.repair;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.QRepair;
import org.apatrios.model.services.Repair;
import org.apatrios.model.services.RepairStatus;
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
                                     .point(argument.point())
                                     .fixType(argument.fixType())
                                     .photos(argument.photos())
                                     .problem(argument.problem())
                                     .number(argument.number())
                                     .status(RepairStatus.CREATED)
                                     .build());
    }

    @Transactional(readOnly = true)
    public Page<Repair> page(@NonNull SearchRepairArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchRepairArgument argument) {
        return QPredicates.builder()
                          .add(argument.problem(), qRepair.problem::containsIgnoreCase)
                          .add(argument.number(), qRepair.number::containsIgnoreCase)
                          .add(argument.fixType(), qRepair.fixType::containsIgnoreCase)
                          .add(argument.status(), qRepair.status::eq)
                          .add(argument.createDateTo(), qRepair.createDate::loe)
                          .add(argument.createDateFrom(), qRepair.createDate::goe)
                          .add(argument.pointId(), qRepair.point.id::eq)
                          .addAnyString(argument.searchString(), qRepair.number::containsIgnoreCase, qRepair.problem::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Repair getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Repair.notFound"));
    }
}
