package org.apatrios.service.management.staff;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.Staff;
import org.apatrios.model.management.QStaff;
import org.apatrios.repository.managment.StaffRepository;
import org.apatrios.service.management.staff.argument.CreateStaffArgument;
import org.apatrios.service.management.staff.argument.SearchStaffArgument;
import org.apatrios.service.management.staff.argument.UpdateStaffArgument;
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
public class StaffService {

    private final StaffRepository repository;
    private final QStaff qStaff = QStaff.staff;

    @Transactional
    public Staff create(@NonNull CreateStaffArgument argument) {
        return repository.save(Staff.builder()
                                    .staffProfile(argument.getStaffProfile())
                                    .position(argument.getPosition())
                                    .franchisee(argument.getFranchisee())
                                    .status(argument.getStatus())
                                    .createDate(LocalDateTime.now())
                                    .updateDate(LocalDateTime.now())
                                    .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Staff update(@NonNull UUID id, @NonNull UpdateStaffArgument argument) {
        Staff existing = getExisting(id);

        existing.setStaffProfile(argument.getStaffProfile());
        existing.setPosition(argument.getPosition());
        existing.setFranchisee(argument.getFranchisee());
        existing.setStatus(argument.getStatus());
        existing.setUpdateDate(LocalDateTime.now());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Staff> list(@NonNull SearchStaffArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Staff> page(@NonNull SearchStaffArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchStaffArgument argument) {
        return QPredicates.builder()
                          .add(argument.getFranchiseeId(), qStaff.franchisee.id::eq)
                          .add(argument.getPosition(), qStaff.position::eq)
                          .add(argument.getStatus(), qStaff.status::eq)
                          .add(argument.getPhone(), qStaff.staffProfile.phone::containsIgnoreCase)
                          .add(argument.getSurname(), qStaff.staffProfile.surname::containsIgnoreCase)
                          .add(argument.getName(), qStaff.staffProfile.name::containsIgnoreCase)
                          .add(argument.getEmail(), qStaff.staffProfile.email::containsIgnoreCase)
                          .add(argument.getCreateDateFrom(), qStaff.createDate::goe)
                          .add(argument.getCreateDateTo(), qStaff.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qStaff.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qStaff.createDate::loe)
                          .add(argument.isDeleted(), qStaff.isDeleted::eq)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Staff getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Staff.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        Staff existing = getExisting(id);
        existing.setDeleted(true);
        repository.save(existing);
    }
}
