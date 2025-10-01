package org.apatrios.repository.managment;

import org.apatrios.model.management.Franchisee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface FranchiseeRepository extends JpaRepository<Franchisee, UUID>, QuerydslPredicateExecutor<Franchisee> {
}
