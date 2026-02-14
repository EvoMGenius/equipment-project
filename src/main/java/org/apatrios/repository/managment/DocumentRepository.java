package org.apatrios.repository.managment;

import org.apatrios.model.management.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface DocumentRepository extends JpaRepository<Document, UUID>, QuerydslPredicateExecutor<Document> {
}
