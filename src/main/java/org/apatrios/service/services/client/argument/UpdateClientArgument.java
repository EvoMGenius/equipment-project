package org.apatrios.service.services.client.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.Franchisee;
import org.apatrios.model.services.ClientProfile;

@Value
@Builder
public class UpdateClientArgument {
    ClientProfile clientProfile;

    Franchisee franchisee;
}
