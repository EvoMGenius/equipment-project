package org.apatrios.repository.services;

import org.apatrios.model.services.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface FeedbackRepository extends JpaRepository<Feedback, UUID>, QuerydslPredicateExecutor<Feedback> {
}
