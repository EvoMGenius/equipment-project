package org.apatrios.repository.equipment;

import org.apatrios.model.equipment.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface BikeRepository extends JpaRepository<Bike, UUID>, QuerydslPredicateExecutor<Bike> {
}
