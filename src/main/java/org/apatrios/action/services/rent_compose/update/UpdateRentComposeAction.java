package org.apatrios.action.services.rent_compose.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.services.Rent;
import org.apatrios.model.services.RentCompose;
import org.apatrios.service.services.rent.RentService;
import org.apatrios.service.services.rent_compose.RentComposeService;
import org.apatrios.service.services.rent_compose.argument.UpdateRentComposeArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateRentComposeAction implements Action<UpdateRentComposeActionArgument, RentCompose> {

    RentService rentService;
    RentComposeService rentComposeService;

    @Override
    @Transactional
    public RentCompose execute(@NonNull UpdateRentComposeActionArgument argument) {
        Rent rent = rentService.getExisting(argument.getRentId());

        return rentComposeService.update(argument.getId(),
                                         UpdateRentComposeArgument.builder()
                                                                  .rent(rent)
                                                                  .amount(argument.getAmount())
                                                                  .objectId(argument.getObjectId())
                                                                  .build());
    }
}
