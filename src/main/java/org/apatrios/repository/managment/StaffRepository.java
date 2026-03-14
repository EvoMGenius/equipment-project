package org.apatrios.repository.managment;

import org.apatrios.model.management.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface StaffRepository extends JpaRepository<Staff, UUID>, QuerydslPredicateExecutor<Staff> {
}
