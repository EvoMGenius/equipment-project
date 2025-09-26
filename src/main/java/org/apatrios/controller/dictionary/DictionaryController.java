package org.apatrios.controller.dictionary;

import org.apatrios.model.dictoinary.BaseDictionary;
import org.apatrios.service.dictionary.DictionaryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public abstract class DictionaryController<T extends BaseDictionary> {

    protected abstract DictionaryService<T> getService();

    @GetMapping
    public ResponseEntity<Page<T>> getAll(Pageable pageable) {
        return ResponseEntity.ok(getService().findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getService().findById(id));
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        return ResponseEntity.ok(getService().create(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable UUID id, @RequestBody T entity) {
        return ResponseEntity.ok(getService().update(id, entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }
}
