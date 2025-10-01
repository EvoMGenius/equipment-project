package org.apatrios.action.services.repair.create;

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
import org.apatrios.service.services.repair.argument.CreateRepairArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateRepairAction implements Action<CreateRepairActionArgument, Repair> {

    StaffService staffService;
    RepairTypeService repairTypeService;
    RepairService repairService;

    @Override
    @Transactional
    public Repair execute(@NonNull CreateRepairActionArgument argument) {
        Staff staff = staffService.getExisting(argument.getStaffId());
        RepairType repairType = repairTypeService.getExisting(argument.getRepairTypeId());

        return repairService.create(CreateRepairArgument.builder()
                                                        .staff(staff)
                                                        .repairType(repairType)
                                                        .comment(argument.getComment())
                                                        .description(argument.getDescription())
                                                        .objectId(argument.getObjectId())
                                                        .build());
    }
}
