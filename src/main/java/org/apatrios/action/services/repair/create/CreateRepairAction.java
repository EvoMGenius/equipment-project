package org.apatrios.action.services.repair.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.equipment.Status;
import org.apatrios.model.management.Point;
import org.apatrios.model.services.Photo;
import org.apatrios.model.services.Repair;
import org.apatrios.service.dictionary.DictService;
import org.apatrios.service.equipment.status.StatusService;
import org.apatrios.service.management.point.PointService;
import org.apatrios.service.services.photo.PhotoService;
import org.apatrios.service.services.repair.RepairService;
import org.apatrios.service.services.repair.argument.CreateRepairArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateRepairAction implements Action<CreateRepairActionArgument, Repair> {

    RepairService repairService;
    PointService pointService;
    DictService dictService;
    PhotoService photoService;
    StatusService statusService;

    @Override
    @Transactional
    public Repair execute(@NonNull CreateRepairActionArgument argument) {
        List<Photo> photos = photoService.getAllByIds(argument.getPhotoIds());
        Point point = pointService.getExisting(argument.getPointId());
        Dict dict = dictService.getExisting(argument.getFixTypeId());
        Status status = statusService.getExisting(argument.getStatusId());

        return repairService.create(CreateRepairArgument.builder()
                                                        .point(point)
                                                        .fixType(dict)
                                                        .photos(photos)
                                                        .problem(argument.getProblem())
                                                        .number(argument.getNumber())
                                                        .status(status)
                                                        .build());
    }
}
