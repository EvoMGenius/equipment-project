package org.apatrios.api.services.client.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.services.client.create.CreateClientActionArgument;
import org.apatrios.action.services.client.update.UpdateClientActionArgument;
import org.apatrios.api.services.client.internal.dto.ClientDto;
import org.apatrios.api.services.client.internal.dto.CreateClientDto;
import org.apatrios.api.services.client.internal.dto.SearchClientDto;
import org.apatrios.api.services.client.internal.dto.UpdateClientDto;
import org.apatrios.model.services.Client;
import org.apatrios.service.services.client.ClientService;
import org.apatrios.service.services.client.argument.SearchClientArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.services.client.internal.mapper.ClientMapper.CLIENT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/client")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ClientController {

    ClientService service;
    Action<CreateClientActionArgument, Client> createClientAction;
    Action<UpdateClientActionArgument, Client> updateClientAction;

    @PostMapping("create")
    public ClientDto create(@Valid @RequestBody CreateClientDto dto) {
        return CLIENT_MAPPER.toDto(createClientAction.execute(CLIENT_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public ClientDto update(@Valid @RequestBody UpdateClientDto dto) {
        return CLIENT_MAPPER.toDto(updateClientAction.execute(CLIENT_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("list")
    public List<ClientDto> list(SearchClientDto dto, Sort sort) {
        SearchClientArgument argument = CLIENT_MAPPER.toSearchArgument(dto);

        return service.list(argument, sort)
                      .stream()
                      .map(CLIENT_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<ClientDto> page(SearchClientDto dto, Pageable pageable) {
        SearchClientArgument argument = CLIENT_MAPPER.toSearchArgument(dto);

        Page<ClientDto> dtoPage = service.page(argument, pageable)
                                         .map(CLIENT_MAPPER::toDto);

        return CollectionDto.of(dtoPage);
    }

    @PostMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
