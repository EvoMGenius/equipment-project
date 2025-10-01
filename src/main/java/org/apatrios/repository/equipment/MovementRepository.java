package org.apatrios.repository.equipment;

import org.apatrios.model.equipment.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface MovementRepository extends JpaRepository<Movement, UUID>, QuerydslPredicateExecutor<Movement> {
}
