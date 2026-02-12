package org.apatrios.repository.equipment;

import org.apatrios.model.equipment.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;
import java.util.UUID;

public interface StatusRepository extends JpaRepository<Status, UUID>, QuerydslPredicateExecutor<Status> {
    Optional<Status> findByCode(String code);
}
