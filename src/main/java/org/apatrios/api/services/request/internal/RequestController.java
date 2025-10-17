package org.apatrios.api.services.request.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.services.request.create.CreateRequestActionArgument;
import org.apatrios.action.services.request.update.UpdateRequestActionArgument;
import org.apatrios.api.services.request.internal.dto.CreateRequestDto;
import org.apatrios.api.services.request.internal.dto.RequestDto;
import org.apatrios.api.services.request.internal.dto.SearchRequestDto;
import org.apatrios.api.services.request.internal.dto.UpdateRequestDto;
import org.apatrios.model.services.Request;
import org.apatrios.service.services.request.RequestService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.services.request.internal.mapper.RequestMapper.REQUEST_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/request")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RequestController {

    RequestService service;
    Action<CreateRequestActionArgument, Request> createRequestAction;
    Action<UpdateRequestActionArgument, Request> updateRequestAction;

    @PostMapping("create")
    public RequestDto create(@Valid @RequestBody CreateRequestDto dto) {
        return REQUEST_MAPPER.toDto(createRequestAction.execute(REQUEST_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public RequestDto update(@Valid @RequestBody UpdateRequestDto dto) {
        return REQUEST_MAPPER.toDto(updateRequestAction.execute(REQUEST_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("list")
    public List<RequestDto> list(SearchRequestDto dto, Sort sort) {
        return service.list(REQUEST_MAPPER.toSearchArgument(dto), sort)
                      .stream()
                      .map(REQUEST_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<RequestDto> page(SearchRequestDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(REQUEST_MAPPER.toSearchArgument(dto), pageable)
                                       .map(REQUEST_MAPPER::toDto));
    }

    @PostMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
