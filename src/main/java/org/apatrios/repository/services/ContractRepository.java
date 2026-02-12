package org.apatrios.repository.services;

import org.apatrios.model.services.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface ContractRepository extends JpaRepository<Contract, UUID>, QuerydslPredicateExecutor<Contract> {
}
