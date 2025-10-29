package org.apatrios.api.dictionary.common.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apatrios.api.dictionary.claim_type.dto.ClaimTypeDto;
import org.apatrios.api.dictionary.component_model.dto.ComponentModelDto;
import org.apatrios.api.dictionary.iot_model.dto.IotModelDto;
import org.apatrios.api.dictionary.model_bike.dto.ModelBikeDto;
import org.apatrios.api.dictionary.outfit_model.dto.OutfitModelDto;
import org.apatrios.api.dictionary.partner.dto.PartnerDto;
import org.apatrios.api.dictionary.payment_type.dto.PaymentTypeDto;
import org.apatrios.api.dictionary.point.dto.PointDto;
import org.apatrios.api.dictionary.point_type.dto.PointTypeDto;
import org.apatrios.api.dictionary.rejection_reason.dto.RejectionReasonDto;
import org.apatrios.api.dictionary.repair_type.dto.RepairTypeDto;
import org.apatrios.api.dictionary.service_dictionary.dto.ServiceDictionaryDto;
import org.apatrios.api.dictionary.tariff.dto.TariffDto;
import org.apatrios.model.dictoinary.EntityStatus;
import org.apatrios.model.dictoinary.ServiceType;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PartnerDto.class, name = "partner"),
        @JsonSubTypes.Type(value = TariffDto.class, name = "tariff"),
        @JsonSubTypes.Type(value = RejectionReasonDto.class, name = "rejectionReason"),
        @JsonSubTypes.Type(value = PointTypeDto.class, name = "pointType"),
        @JsonSubTypes.Type(value = OutfitModelDto.class, name = "outfitModel"),
        @JsonSubTypes.Type(value = ClaimTypeDto.class, name = "claimType"),
        @JsonSubTypes.Type(value = ModelBikeDto.class, name = "modelBike"),
        @JsonSubTypes.Type(value = ComponentModelDto.class, name = "componentModel"),
        @JsonSubTypes.Type(value = IotModelDto.class, name = "iotModel"),
        @JsonSubTypes.Type(value = PaymentTypeDto.class, name = "paymentType"),
        @JsonSubTypes.Type(value = PointDto.class, name = "point"),
        @JsonSubTypes.Type(value = RepairTypeDto.class, name = "repairType"),
        @JsonSubTypes.Type(value = ServiceDictionaryDto.class, name = "service"),
        @JsonSubTypes.Type(value = ServiceType.class, name = "serviceType"),
})
@Schema(description = "Базовый DTO поиска справочника")
public abstract class BaseDictionarySearchDto {

    @Schema(description = "Наименование")
    String name;

    @Schema(description = "Статус")
    EntityStatus status;
}
