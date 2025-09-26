package org.apatrios.repository.dictionary;

import org.apatrios.model.dictoinary.BaseDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface DictionaryRepository<T extends BaseDictionary>
        extends JpaRepository<T, UUID>, QuerydslPredicateExecutor<T> {

    boolean existsByName(String name);
}
