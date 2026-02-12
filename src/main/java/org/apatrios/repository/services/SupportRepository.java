package org.apatrios.repository.services;

import org.apatrios.model.services.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface SupportRepository extends JpaRepository<Support, UUID>, QuerydslPredicateExecutor<Support> {
}
