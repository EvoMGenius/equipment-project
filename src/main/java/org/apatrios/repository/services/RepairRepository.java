package org.apatrios.repository.services;

import org.apatrios.model.services.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface RepairRepository extends JpaRepository<Repair, UUID>, QuerydslPredicateExecutor<Repair> {
}
