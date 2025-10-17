package org.apatrios.repository.managment;

import org.apatrios.model.management.ManagementPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface ManagementPointRepository extends JpaRepository<ManagementPoint, UUID>, QuerydslPredicateExecutor<ManagementPoint> {
}
