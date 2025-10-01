package org.apatrios.repository.equipment;

import org.apatrios.model.equipment.EquipmentComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface EquipmentComponentRepository extends JpaRepository<EquipmentComponent, UUID>, QuerydslPredicateExecutor<EquipmentComponent> {
}
