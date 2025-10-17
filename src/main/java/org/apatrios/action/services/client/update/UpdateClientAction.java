package org.apatrios.action.services.client.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.management.Franchisee;
import org.apatrios.model.services.Client;
import org.apatrios.service.management.franchisee.FranchiseeService;
import org.apatrios.service.services.client.ClientService;
import org.apatrios.service.services.client.argument.UpdateClientArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateClientAction implements Action<UpdateClientActionArgument, Client> {

    ClientService clientService;
    FranchiseeService franchiseeService;

    @Override
    @Transactional
    public Client execute(@NonNull UpdateClientActionArgument argument) {
        Franchisee franchisee = franchiseeService.getExisting(argument.getFranchiseeId());

        return clientService.update(argument.getId(),
                                    UpdateClientArgument.builder()
                                                        .clientProfile(argument.getClientProfile())
                                                        .franchisee(franchisee)
                                                        .status(argument.getStatus())
                                                        .build());
    }
}
