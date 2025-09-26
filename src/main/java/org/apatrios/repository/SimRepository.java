package org.apatrios.repository;

import org.apatrios.model.Bike;
import org.apatrios.model.Sim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface SimRepository extends JpaRepository<Sim, UUID>, QuerydslPredicateExecutor<Sim> {
}
