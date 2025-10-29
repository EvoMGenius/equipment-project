package org.apatrios.service.management.staff.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.Position;
import org.apatrios.model.management.StaffStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchStaffArgument {

    String phone;

    String surname;

    String searchString;

    String name;

    String email;

    Position position;

    UUID franchiseeId;

    StaffStatus status;

    LocalDateTime createDateFrom;

    LocalDateTime createDateTo;

    LocalDateTime updateDateFrom;

    LocalDateTime updateDateTo;

    boolean isDeleted;
}
