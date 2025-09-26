package org.apatrios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface ComponentRepository extends JpaRepository<org.apatrios.model.Component, UUID>, QuerydslPredicateExecutor<org.apatrios.model.Component> {
}
