package org.apatrios.repository.managment;

import org.apatrios.model.management.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID>, QuerydslPredicateExecutor<Company> {
}
