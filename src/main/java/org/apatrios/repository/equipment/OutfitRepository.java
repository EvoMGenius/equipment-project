package org.apatrios.repository.equipment;

import org.apatrios.model.equipment.Outfit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface OutfitRepository extends JpaRepository<Outfit, UUID>, QuerydslPredicateExecutor<Outfit> {
}
