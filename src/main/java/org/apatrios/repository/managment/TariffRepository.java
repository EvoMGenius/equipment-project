package org.apatrios.repository.managment;

import org.apatrios.model.management.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface TariffRepository extends JpaRepository<Tariff, UUID>, QuerydslPredicateExecutor<Tariff> {
}
