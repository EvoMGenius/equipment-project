package org.apatrios.action.services.request.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.dictoinary.RejectionReason;
import org.apatrios.model.dictoinary.ServiceType;
import org.apatrios.model.services.Client;
import org.apatrios.model.services.Request;
import org.apatrios.service.dictionary.ModelBikeService;
import org.apatrios.service.dictionary.RejectionReasonService;
import org.apatrios.service.dictionary.ServiceTypeService;
import org.apatrios.service.services.client.ClientService;
import org.apatrios.service.services.request.RequestService;
import org.apatrios.service.services.request.argument.CreateRequestArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateRequestAction implements Action<CreateRequestActionArgument, Request> {

    ClientService clientService;
    ModelBikeService modelBikeService;
    ServiceTypeService serviceTypeService;
    RequestService requestService;
    RejectionReasonService rejectionReasonService;

    @Override
    @Transactional
    public Request execute(@NonNull CreateRequestActionArgument argument) {
        Client client = clientService.getExisting(argument.getClientId());
        ModelBike modelBike = modelBikeService.getExisting(argument.getModelBikeId());
        ServiceType serviceType = serviceTypeService.getExisting(argument.getServiceTypeId());
        RejectionReason reason = argument.getRejectionReasonId() != null
                                 ? rejectionReasonService.getExisting(argument.getRejectionReasonId())
                                 : null;

        return requestService.create(CreateRequestArgument.builder()
                                                          .serviceType(serviceType)
                                                          .client(client)
                                                          .modelBike(modelBike)
                                                          .note(argument.getNote())
                                                          .requestProfile(argument.getRequestProfile())
                                                          .rejectionReason(reason)
                                                          .note(argument.getNote())
                                                          .build());
    }
}
