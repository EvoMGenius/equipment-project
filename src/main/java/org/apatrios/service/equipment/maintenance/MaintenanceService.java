package org.apatrios.service.equipment.maintenance;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.equipment.Maintenance;
import org.apatrios.model.equipment.MaintenanceStatus;
import org.apatrios.model.equipment.QMaintenance;
import org.apatrios.repository.equipment.MaintenanceRepository;
import org.apatrios.service.equipment.maintenance.argument.CreateMaintenanceArgument;
import org.apatrios.service.equipment.maintenance.argument.SearchMaintenanceArgument;
import org.apatrios.service.equipment.maintenance.argument.UpdateMaintenanceArgument;
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
public class MaintenanceService {

    private final MaintenanceRepository repository;
    private final QMaintenance qMaintenance = QMaintenance.maintenance;

    @Transactional
    public Maintenance create(@NonNull CreateMaintenanceArgument argument) {
        return repository.save(Maintenance.builder()
                                          .bicycleVin(argument.getBicycleVin())
                                          .completedWork(argument.getCompletedWork())
                                          .startDate(argument.getStartDate())
                                          .endDate(argument.getEndDate())
                                          .createDate(LocalDateTime.now())
                                          .updateDate(LocalDateTime.now())
                                          .status(MaintenanceStatus.NEW)
                                          .franchiseeIds(argument.getFranchiseeIds())
                                          .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Maintenance update(@NonNull UUID id, @NonNull UpdateMaintenanceArgument argument) {
        Maintenance maintenance = getExisting(id);

        maintenance.setUpdateDate(LocalDateTime.now());
        maintenance.setBicycleVin(argument.getBicycleVin());
        maintenance.setCompletedWork(argument.getCompletedWork());
        maintenance.setEndDate(argument.getEndDate());
        maintenance.setStatus(argument.getStatus());
        maintenance.setFranchiseeIds(argument.getFranchiseeIds());

        return repository.save(maintenance);
    }

    @Transactional(readOnly = true)
    public Maintenance getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Maintenance.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Maintenance> list(@NonNull SearchMaintenanceArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Maintenance> page(@NonNull SearchMaintenanceArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchMaintenanceArgument argument) {
        return QPredicates.builder()
                          .add(argument.getCreateDateFrom(), qMaintenance.createDate::goe)
                          .add(argument.getCreateDateTo(), qMaintenance.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qMaintenance.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qMaintenance.updateDate::loe)
                          .add(argument.isDeleted(), qMaintenance.isDeleted::eq)
                          .add(argument.getBicycleVin(), qMaintenance.bicycleVin::containsIgnoreCase)
                          .add(argument.getCompletedWork(), work -> buildJsonbTextSearchExpression(qMaintenance.completedWork, work))
                          .add(argument.getStartDateFrom(), qMaintenance.startDate::goe)
                          .add(argument.getStartDateTo(), qMaintenance.startDate::loe)
                          .add(argument.getEndDateFrom(), qMaintenance.endDate::goe)
                          .add(argument.getEndDateTo(), qMaintenance.endDate::loe)
                          .add(argument.getStatus(), qMaintenance.status::eq)
                          .add(argument.getFranchiseeIds(), qMaintenance.franchiseeIds.any()::in)
                          .addAnyString(argument.getSearchString(),
                                        qMaintenance.status.stringValue()::containsIgnoreCase,
                                        qMaintenance.bicycleVin::containsIgnoreCase,
                                        work -> buildJsonbTextSearchExpression(qMaintenance.completedWork, work))
                          .buildAnd();
    }

    @SneakyThrows
    private BooleanExpression buildJsonbTextSearchExpression(Object path, String searchText) {
        return Expressions.booleanTemplate("jsonb_array_contains_text({0}, {1})", path, searchText).isTrue();
    }
}
