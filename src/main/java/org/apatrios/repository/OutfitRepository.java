package org.apatrios.repository;

import org.apatrios.model.Bike;
import org.apatrios.model.Outfit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface OutfitRepository extends JpaRepository<Outfit, UUID>, QuerydslPredicateExecutor<Outfit> {
}
