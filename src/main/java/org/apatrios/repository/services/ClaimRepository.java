package org.apatrios.repository.services;

import org.apatrios.model.services.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface ClaimRepository extends JpaRepository<Claim, UUID>, QuerydslPredicateExecutor<Claim> {
}
