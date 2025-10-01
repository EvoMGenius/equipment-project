package org.apatrios.service.management.staff.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.Franchisee;
import org.apatrios.model.management.Position;
import org.apatrios.model.management.StaffProfile;
import org.apatrios.model.management.StaffStatus;

@Value
@Builder
public class UpdateStaffArgument {
    StaffProfile staffProfile;

    Franchisee franchisee;

    Position position;

    StaffStatus status;
}
