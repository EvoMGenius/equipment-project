package org.apatrios.repository.equipment;

import org.apatrios.model.equipment.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface MaintenanceRepository extends JpaRepository<Maintenance, UUID>, QuerydslPredicateExecutor<Maintenance> {
}
