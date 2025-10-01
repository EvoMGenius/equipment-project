package org.apatrios.action.management.staff.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.Position;
import org.apatrios.model.management.StaffProfile;
import org.apatrios.model.management.StaffStatus;

import java.util.UUID;

@Value
@Builder
public class UpdateStaffActionArgument {
    UUID id;

    StaffProfile staffProfile;

    UUID franchiseeId;

    Position position;

    StaffStatus status;
}
