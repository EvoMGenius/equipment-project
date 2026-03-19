package org.apatrios.action.services.repair;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.services.repair.argument.CreateRepairActionArgument;
import org.apatrios.model.management.Point;
import org.apatrios.model.services.Repair;
import org.apatrios.service.management.point.PointService;
import org.apatrios.service.services.repair.RepairService;
import org.apatrios.service.services.repair.argument.CreateRepairArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateRepairAction implements Action<CreateRepairActionArgument, Repair> {

    RepairService repairService;
    PointService pointService;

    @Override
    @Transactional
    public Repair execute(@NonNull CreateRepairActionArgument argument) {
        Point point = pointService.getExisting(argument.pointId());

        return repairService.create(CreateRepairArgument.builder()
                                                        .point(point)
                                                        .fixType(argument.fixType())
                                                        .photos(argument.photos())
                                                        .problem(argument.problem())
                                                        .number(argument.number())
                                                        .build());
    }
}
