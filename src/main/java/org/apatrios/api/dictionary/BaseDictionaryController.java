package org.apatrios.api.dictionary;

import org.apatrios.api.dictionary.common.dto.BaseDictionaryDto;
import org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.model.dictoinary.BaseDictionary;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class BaseDictionaryController<
        T extends BaseDictionary,
        SearchArgumentT extends BaseDictionarySearchArgument,
        SearchDtoT extends BaseDictionarySearchDto,
        DictionaryDtoT extends BaseDictionaryDto> {

    protected abstract BaseDictionaryService<T, SearchArgumentT, ?> getService();

    protected abstract BaseDictionaryMapper<T, DictionaryDtoT, SearchDtoT, SearchArgumentT> getMapper();

    @GetMapping("/page")
    public CollectionDto<DictionaryDtoT> page(@RequestBody SearchDtoT dto, Pageable pageable) {
        return CollectionDto.of(getService().page(pageable, getMapper().toSearchArgument(dto)).map(getMapper()::toDto));
    }

    @GetMapping("/list")
    public List<DictionaryDtoT> getAll(@RequestBody SearchDtoT dto, Sort sort) {
        SearchArgumentT searchArg = getMapper().toSearchArgument(dto);
        return getService().list(searchArg, sort).stream()
                                             .map(getMapper()::toDto)
                                             .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DictionaryDtoT getById(@PathVariable UUID id) {
        return getMapper().toDto(getService().getExisting(id));
    }

    @PostMapping("/create")
    public DictionaryDtoT create(@RequestBody T entity) {
        return getMapper().toDto(getService().create(entity));
    }

    @PutMapping("/{id}/update")
    public DictionaryDtoT update(@PathVariable UUID id, @RequestBody T entity) {
        return getMapper().toDto(getService().update(id, entity));
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable UUID id) {
        getService().delete(id);
    }
}
