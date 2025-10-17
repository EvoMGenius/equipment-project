package org.apatrios.action.services.client.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.management.Franchisee;
import org.apatrios.model.services.Client;
import org.apatrios.service.management.franchisee.FranchiseeService;
import org.apatrios.service.services.client.ClientService;
import org.apatrios.service.services.client.argument.CreateClientArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateClientAction implements Action<CreateClientActionArgument, Client> {

    FranchiseeService franchiseeService;
    ClientService clientService;

    @Override
    @Transactional
    public Client execute(@NonNull CreateClientActionArgument argument) {
        Franchisee franchisee = franchiseeService.getExisting(argument.getFranchiseeId());

        return clientService.create(CreateClientArgument.builder()
                                                        .franchisee(franchisee)
                                                        .clientProfile(argument.getClientProfile())
                                                        .build());
    }
}
