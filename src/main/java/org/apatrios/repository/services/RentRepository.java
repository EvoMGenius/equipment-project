package org.apatrios.repository.services;

import org.apatrios.model.services.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface RentRepository extends JpaRepository<Rent, UUID>, QuerydslPredicateExecutor<Rent> {
}
