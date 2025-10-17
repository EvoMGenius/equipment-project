package org.apatrios.service.management.franchisee.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.FranchiseeStatus;

import java.time.LocalDateTime;

@Value
@Builder
public class SearchFranchiseeArgument {
    String phone;

    String name;

    String email;

    String address;

    String inn;

    FranchiseeStatus status;

    LocalDateTime createDateFrom;

    LocalDateTime createDateTo;

    LocalDateTime updateDateFrom;

    LocalDateTime updateDateTo;

    boolean isDeleted;
}
