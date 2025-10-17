package org.apatrios.repository.services;

import org.apatrios.model.services.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface RecruitRepository extends JpaRepository<Recruit, UUID>, QuerydslPredicateExecutor<Recruit> {
}
