package org.apatrios.repository;

import org.apatrios.model.Bike;
import org.apatrios.model.Iot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface IotRepository extends JpaRepository<Iot, UUID>, QuerydslPredicateExecutor<Iot> {
}
