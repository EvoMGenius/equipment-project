package org.apatrios.repository.equipment;

import org.apatrios.model.equipment.SimBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface SimBalanceRepository extends JpaRepository<SimBalance, UUID>, QuerydslPredicateExecutor<SimBalance> {
}
