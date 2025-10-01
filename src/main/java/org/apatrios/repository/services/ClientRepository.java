package org.apatrios.repository.services;

import org.apatrios.model.services.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID>, QuerydslPredicateExecutor<Client> {
}
