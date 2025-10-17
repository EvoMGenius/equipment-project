package org.apatrios.repository.equipment;

import org.apatrios.model.equipment.Sim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface SimRepository extends JpaRepository<Sim, UUID>, QuerydslPredicateExecutor<Sim> {
}
