package org.apatrios.action.services.support.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.services.Photo;
import org.apatrios.model.services.Repair;
import org.apatrios.model.services.Support;
import org.apatrios.service.dictionary.DictService;
import org.apatrios.service.services.photo.PhotoService;
import org.apatrios.service.services.repair.RepairService;
import org.apatrios.service.services.support.SupportService;
import org.apatrios.service.services.support.argument.CreateSupportArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateSupportAction implements Action<CreateSupportActionArgument, Support> {

    SupportService supportService;
    PhotoService photoService;
    RepairService repairService;
    DictService dictService;

    @Override
    @Transactional
    public Support execute(@NonNull CreateSupportActionArgument argument) {
        Dict dict = dictService.getExisting(argument.getTypeId());
        List<Photo> photos = photoService.getAllByIds(argument.getPhotoIds());
        Repair repair = repairService.getExisting(argument.getChildRepairId());

        return supportService.create(CreateSupportArgument.builder()
                                                          .type(dict)
                                                          .description(argument.getDescription())
                                                          .photo(photos)
                                                          .childRepairId(repair)
                                                          .build());
    }
}
