package org.apatrios.repository.managment;

import org.apatrios.model.management.Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface TelemetryRepository extends JpaRepository<Telemetry, UUID>, QuerydslPredicateExecutor<Telemetry> {
}
