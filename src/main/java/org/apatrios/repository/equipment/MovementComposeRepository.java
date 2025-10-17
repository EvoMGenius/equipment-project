package org.apatrios.repository.equipment;

import org.apatrios.model.equipment.MovementCompose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface MovementComposeRepository extends JpaRepository<MovementCompose, UUID>, QuerydslPredicateExecutor<MovementCompose> {
}
