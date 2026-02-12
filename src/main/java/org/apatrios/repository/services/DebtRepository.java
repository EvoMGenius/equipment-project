package org.apatrios.repository.services;

import org.apatrios.model.services.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface DebtRepository extends JpaRepository<Debt, UUID>, QuerydslPredicateExecutor<Debt> {
}
