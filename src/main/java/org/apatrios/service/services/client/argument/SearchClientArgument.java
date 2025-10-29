package org.apatrios.service.services.client.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.ClientStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchClientArgument {
    String phone;

    String surname;

    String searchString;

    String name;

    UUID franchiseeId;

    LocalDateTime createDateFrom;

    LocalDateTime createDateTo;

    LocalDateTime updateDateFrom;

    LocalDateTime updateDateTo;

    boolean isDeleted;

    ClientStatus status;
}
