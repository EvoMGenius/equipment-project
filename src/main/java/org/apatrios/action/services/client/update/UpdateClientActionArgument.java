package org.apatrios.action.services.client.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.ClientProfile;
import org.apatrios.model.services.ClientStatus;

import java.util.UUID;

@Value
@Builder
public class UpdateClientActionArgument {
    UUID id;

    ClientProfile clientProfile;

    ClientStatus status;

    UUID franchiseeId;
}
