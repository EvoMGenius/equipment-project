package org.apatrios.service.management.staff;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.QStaff;
import org.apatrios.model.management.Staff;
import org.apatrios.model.management.StaffStatus;
import org.apatrios.repository.managment.StaffRepository;
import org.apatrios.service.management.staff.argument.CreateStaffArgument;
import org.apatrios.service.management.staff.argument.SearchStaffArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StaffService {

    private final StaffRepository repository;
    private final QStaff qStaff = QStaff.staff;

    @Transactional
    public Staff create(@NonNull CreateStaffArgument argument) {
        return repository.save(Staff.builder()
                                    .surname(argument.surname())
                                    .name(argument.name())
                                    .position(argument.position())
                                    .company(argument.company())
                                    .phone(argument.phone())
                                    .email(argument.email())
                                    .status(StaffStatus.CREATED)
                                    .build());
    }

    @Transactional(readOnly = true)
    public Page<Staff> page(@NonNull SearchStaffArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchStaffArgument argument) {
        return QPredicates.builder()
                          .add(argument.surname(), qStaff.surname::containsIgnoreCase)
                          .add(argument.name(), qStaff.name::containsIgnoreCase)
                          .add(argument.position(), qStaff.position::containsIgnoreCase)
                          .add(argument.companyId(), qStaff.company.id::eq)
                          .add(argument.phone(), qStaff.phone::containsIgnoreCase)
                          .add(argument.email(), qStaff.email::containsIgnoreCase)
                          .add(argument.status(), qStaff.status::eq)
                          .add(argument.isDeleted(), qStaff.isDeleted::eq)
                          .add(argument.createDateFrom(), qStaff.createDate::goe)
                          .add(argument.createDateTo(), qStaff.createDate::loe)
                          .add(argument.updateDateFrom(), qStaff.updateDate::goe)
                          .add(argument.updateDateTo(), qStaff.updateDate::loe)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Staff getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Staff.notFound"));
    }
}