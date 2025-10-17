package org.apatrios.repository.services;

import org.apatrios.model.services.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface RequestRepository extends JpaRepository<Request, UUID>, QuerydslPredicateExecutor<Request> {
}
