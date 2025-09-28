package org.apatrios.controller.dictionary;

import com.google.common.collect.Lists;
import org.apatrios.controller.dictionary.dto.BaseDictionarySearchDto;
import org.apatrios.model.dictoinary.BaseDictionary;
import org.apatrios.service.dictionary.SimpleDictionaryService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class BaseDictionaryController<T extends BaseDictionary, SearchArgumentT extends BaseDictionarySearchArgument, SearchDtoT extends BaseDictionarySearchDto> {

    protected abstract SimpleDictionaryService<T> getService();

    protected abstract SearchArgumentT toSearch(SearchDtoT var1);

    @GetMapping("/page")
    public ResponseEntity<CollectionDto<T>> page(@RequestBody SearchDtoT dto, Pageable pageable) {
        Page<T> page = getService().page(pageable, this.toSearch(dto));
        return ResponseEntity.ok(CollectionDto.of(page));
    }

    @GetMapping("/list")
    public List<T> getAll(@RequestBody SearchDtoT dto, Sort sort) {
        return Lists.newArrayList(getService().list(toSearch(dto), sort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(getService().getExisting(id));
    }

    @PostMapping("/create")
    public ResponseEntity<T> create(@RequestBody T entity) {
        return ResponseEntity.ok(getService().create(entity));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<T> update(@PathVariable UUID id, @RequestBody T entity) {
        return ResponseEntity.ok(getService().update(id, entity));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }
}
