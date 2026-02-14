package org.apatrios.repository.services;

import org.apatrios.model.services.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface PhotoRepository extends JpaRepository<Photo, UUID>, QuerydslPredicateExecutor<Photo> {
}
