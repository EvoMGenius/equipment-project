package org.apatrios.repository.equipment;

import org.apatrios.model.equipment.Iot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface IotRepository extends JpaRepository<Iot, UUID>, QuerydslPredicateExecutor<Iot> {
}
