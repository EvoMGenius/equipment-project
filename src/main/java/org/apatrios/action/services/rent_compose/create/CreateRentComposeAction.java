package org.apatrios.action.services.rent_compose.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.services.Rent;
import org.apatrios.model.services.RentCompose;
import org.apatrios.service.services.rent.RentService;
import org.apatrios.service.services.rent_compose.RentComposeService;
import org.apatrios.service.services.rent_compose.argument.CreateRentComposeArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateRentComposeAction implements Action<CreateRentComposeActionArgument, RentCompose> {

    RentService rentService;
    RentComposeService rentComposeService;

    @Override
    @Transactional
    public RentCompose execute(@NonNull CreateRentComposeActionArgument argument) {
        Rent rent = rentService.getExisting(argument.getRentId());

        return rentComposeService.create(CreateRentComposeArgument.builder()
                                                                  .rent(rent)
                                                                  .amount(argument.getAmount())
                                                                  .objectId(argument.getObjectId())
                                                                  .build());
    }
}
