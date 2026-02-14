package org.apatrios.repository.managment;

import org.apatrios.model.management.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface PointRepository extends JpaRepository<Point, UUID>, QuerydslPredicateExecutor<Point> {
}
