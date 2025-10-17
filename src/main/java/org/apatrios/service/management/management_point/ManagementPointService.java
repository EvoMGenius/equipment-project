package org.apatrios.service.management.management_point;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.ManagementPoint;
import org.apatrios.model.management.PointStatus;
import org.apatrios.model.management.QManagementPoint;
import org.apatrios.repository.managment.ManagementPointRepository;
import org.apatrios.service.management.management_point.argument.CreateManagementPointArgument;
import org.apatrios.service.management.management_point.argument.SearchManagementPointArgument;
import org.apatrios.service.management.management_point.argument.UpdateManagementPointArgument;
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
public class ManagementPointService {

    private final ManagementPointRepository repository;
    private final QManagementPoint qPoint = QManagementPoint.managementPoint;

    @Transactional
    public ManagementPoint create(@NonNull CreateManagementPointArgument argument) {
        return repository.save(ManagementPoint.builder()
                                              .name(argument.getName())
                                              .address(argument.getAddress())
                                              .franchisee(argument.getFranchisee())
                                              .pointType(argument.getPointType())
                                              .status(PointStatus.ACTIVE)
                                              .latitude(argument.getLatitude())
                                              .longitude(argument.getLongitude())
                                              .createDate(LocalDateTime.now())
                                              .updateDate(LocalDateTime.now())
                                              .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public ManagementPoint update(@NonNull UUID id, @NonNull UpdateManagementPointArgument argument) {
        ManagementPoint existing = getExisting(id);

        existing.setName(argument.getName());
        existing.setAddress(argument.getAddress());
        existing.setFranchisee(argument.getFranchisee());
        existing.setPointType(argument.getPointType());
        existing.setStatus(argument.getStatus());
        existing.setLatitude(argument.getLatitude());
        existing.setLongitude(argument.getLongitude());
        existing.setUpdateDate(LocalDateTime.now());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<ManagementPoint> list(@NonNull SearchManagementPointArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<ManagementPoint> page(@NonNull SearchManagementPointArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchManagementPointArgument argument) {
        return QPredicates.builder()
                          .add(argument.getName(), qPoint.name::containsIgnoreCase)
                          .add(argument.getAddress(), qPoint.address::containsIgnoreCase)
                          .add(argument.getFranchiseeId(), qPoint.franchisee.id::eq)
                          .add(argument.getPointTypeId(), qPoint.pointType.id::eq)
                          .add(argument.getStatus(), qPoint.status::eq)
                          .add(argument.getLatitude(), qPoint.latitude::eq)
                          .add(argument.getLongitude(), qPoint.longitude::eq)
                          .add(argument.getCreateDateFrom(), qPoint.createDate::goe)
                          .add(argument.getCreateDateTo(), qPoint.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qPoint.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qPoint.updateDate::loe)
                          .add(argument.isDeleted(), qPoint.isDeleted::eq)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public ManagementPoint getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Point.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        ManagementPoint existing = getExisting(id);
        existing.setDeleted(true);
        repository.save(existing);
    }
}
