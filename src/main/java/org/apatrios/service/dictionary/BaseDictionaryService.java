package org.apatrios.service.dictionary;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringPath;
import lombok.NonNull;
import org.apatrios.model.dictoinary.BaseDictionary;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public abstract class BaseDictionaryService<T extends BaseDictionary, SearchArgumentT extends BaseDictionarySearchArgument, QT extends EntityPathBase<T>> {

    protected abstract BaseDictionaryRepository<T> getRepository();

    protected abstract QT getQRoot();

    @Transactional(readOnly = true)
    public Page<T> page(@NonNull Pageable pageable, @NonNull SearchArgumentT argument) {
        return getRepository().findAll(buildPredicates(argument), pageable);
    }

    @Transactional(readOnly = true)
    public List<T> list(@NonNull SearchArgumentT argument, @NonNull Sort sort) {
        return Lists.newArrayList(getRepository().findAll(buildPredicates(argument), sort));
    }

    @Transactional(readOnly = true)
    public T getExisting(@NonNull UUID id) {
        return getRepository().findById(id)
                              .orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
    }

    @Transactional
    public T create(@NonNull T entity) {
        return getRepository().save(entity);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public T update(@NonNull UUID id, @NonNull T entity) {
        T existing = getExisting(id);
        entity.setId(id);
        entity.setName(existing.getName());
        return getRepository().save(entity);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        T entity = getExisting(id);
        getRepository().delete(entity);
    }

    protected Predicate buildPredicates(@NonNull SearchArgumentT argument) {
        StringPath namePath = Expressions.stringPath(getQRoot(), "name");
        return QPredicates.builder()
                          .add(argument.getName(), namePath::containsIgnoreCase)
                          .buildAnd();
    }
}
