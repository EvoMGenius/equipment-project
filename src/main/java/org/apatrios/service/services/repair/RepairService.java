package org.apatrios.service.services.repair;

import com.google.common.collect.Lists;
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
import org.apatrios.service.services.repair.argument.UpdateRepairArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RepairService {

    private final RepairRepository repository;
    private final QRepair qRepair = QRepair.repair;

    @Transactional
    public Repair create(@NonNull CreateRepairArgument argument) {
        return repository.save(Repair.builder()
                                     .objectId(argument.getObjectId())
                                     .repairType(argument.getRepairType())
                                     .staff(argument.getStaff())
                                     .description(argument.getDescription())
                                     .status(RepairStatus.NEW)
                                     .createDate(LocalDateTime.now())
                                     .updateDate(LocalDateTime.now())
                                     .comment(argument.getComment())
                                     .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Repair update(@NonNull UUID id, @NonNull UpdateRepairArgument argument) {
        Repair existing = getExisting(id);

        existing.setObjectId(argument.getObjectId());
        existing.setRepairType(argument.getRepairType());
        existing.setStaff(argument.getStaff());
        existing.setDescription(argument.getDescription());
        existing.setStatus(argument.getStatus());
        existing.setDateEnd(argument.getDateEnd());
        existing.setComment(argument.getComment());
        existing.setUpdateDate(LocalDateTime.now());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Repair> list(@NonNull SearchRepairArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Repair> page(@NonNull SearchRepairArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchRepairArgument argument) {
        return QPredicates.builder()
                          .add(argument.getObjectId(), qRepair.objectId::eq)
                          .add(argument.getRepairTypeId(), qRepair.repairType.id::eq)
                          .add(argument.getStaffId(), qRepair.staff.id::eq)
                          .add(argument.getDescription(), qRepair.description::containsIgnoreCase)
                          .add(argument.getStatus(), qRepair.status::eq)
                          .add(argument.getDateEnd(), qRepair.dateEnd::loe)
                          .add(argument.getCreateDate(), qRepair.createDate::goe)
                          .add(argument.getUpdateDateFrom(), qRepair.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qRepair.updateDate::loe)
                          .add(argument.isDeleted(), qRepair.isDeleted::eq)
                          .add(argument.getComment(), qRepair.comment::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Repair getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Repair.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        Repair existing = getExisting(id);
        existing.setDeleted(true);
        repository.save(existing);
    }
}
