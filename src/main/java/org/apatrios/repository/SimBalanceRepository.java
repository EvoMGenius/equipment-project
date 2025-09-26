package org.apatrios.repository;

import org.apatrios.model.Bike;
import org.apatrios.model.SimBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface SimBalanceRepository extends JpaRepository<SimBalance, UUID>, QuerydslPredicateExecutor<SimBalance> {
}
