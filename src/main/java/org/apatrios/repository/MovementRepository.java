package org.apatrios.repository;

import org.apatrios.model.Bike;
import org.apatrios.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface MovementRepository extends JpaRepository<Movement, UUID>, QuerydslPredicateExecutor<Movement> {
}
