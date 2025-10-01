package org.apatrios.repository.services;

import org.apatrios.model.services.RentCompose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface RentComposeRepository extends JpaRepository<RentCompose, UUID>, QuerydslPredicateExecutor<RentCompose> {
}
