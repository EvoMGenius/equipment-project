package org.apatrios.action.services.repair.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.RepairType;
import org.apatrios.model.management.Staff;
import org.apatrios.model.services.Repair;
import org.apatrios.service.dictionary.RepairTypeService;
import org.apatrios.service.management.staff.StaffService;
import org.apatrios.service.services.repair.RepairService;
import org.apatrios.service.services.repair.argument.UpdateRepairArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateRepairAction implements Action<UpdateRepairActionArgument, Repair> {

    StaffService staffService;
    RepairTypeService repairTypeService;
    RepairService repairService;

    @Override
    @Transactional
    public Repair execute(@NonNull UpdateRepairActionArgument argument) {
        Staff staff = staffService.getExisting(argument.getStaffId());
        RepairType repairType = repairTypeService.getExisting(argument.getRepairTypeId());

        return repairService.update(argument.getId(),
                                    UpdateRepairArgument.builder()
                                                        .staff(staff)
                                                        .repairType(repairType)
                                                        .comment(argument.getComment())
                                                        .description(argument.getDescription())
                                                        .objectId(argument.getObjectId())
                                                        .dateEnd(argument.getDateEnd())
                                                        .status(argument.getStatus())
                                                        .build());
    }
}
