package org.apatrios.service.dictionary;

import org.apatrios.model.dictoinary.BaseDictionary;
import org.apatrios.model.dictoinary.EntityStatus;
import org.apatrios.repository.dictionary.DictionaryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public abstract class DictionaryService<T extends BaseDictionary> {

    protected abstract DictionaryRepository<T> getRepository();

    @Transactional(readOnly = true)
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Transactional(readOnly = true)
    public T findById(UUID id) {
        return getRepository().findById(id)
                              .orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
    }

    @Transactional
    public T create(T entity) {
        return getRepository().save(entity);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public T update(UUID id, T entity) {
        T existing = findById(id);
        entity.setId(id);
        entity.setCreateDate(existing.getCreateDate());
        return getRepository().save(entity);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(UUID id) {
        T entity = findById(id);
        getRepository().delete(entity);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void softDelete(UUID id) {
        T entity = findById(id);
        entity.setStatus(EntityStatus.DELETED);
        getRepository().save(entity);
    }
}
