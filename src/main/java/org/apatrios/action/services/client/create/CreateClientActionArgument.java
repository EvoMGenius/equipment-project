package org.apatrios.action.services.client.create;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.ClientProfile;

import java.util.UUID;

@Value
@Builder
public class CreateClientActionArgument {
    ClientProfile clientProfile;

    UUID franchiseeId;
}
