package org.apatrios.service.equipment.bike.argument;

import lombok.Builder;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.equipment.Iot;
import org.apatrios.model.management.Company;

@Builder
public record CreateBikeArgument(
        ModelBike modelBike,
        Company company,
        Integer seqNumber,
        Integer invNumber,
        String vin,
        String motorWheel,
        Iot iot,
        String comment,
        Boolean isDeleted
) {
}
