package org.apatrios.api.services.client.internal.mapper;

import org.apatrios.action.services.client.create.CreateClientActionArgument;
import org.apatrios.action.services.client.update.UpdateClientActionArgument;
import org.apatrios.api.services.client.internal.dto.ClientDto;
import org.apatrios.api.services.client.internal.dto.CreateClientDto;
import org.apatrios.api.services.client.internal.dto.SearchClientDto;
import org.apatrios.api.services.client.internal.dto.UpdateClientDto;
import org.apatrios.model.services.Client;
import org.apatrios.service.services.client.argument.SearchClientArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper CLIENT_MAPPER = Mappers.getMapper(ClientMapper.class);

    ClientDto toDto(Client client);
    CreateClientActionArgument toCreateArgument(CreateClientDto dto);
    UpdateClientActionArgument toUpdateArgument(UpdateClientDto dto);
    SearchClientArgument toSearchArgument(SearchClientDto dto);
}
