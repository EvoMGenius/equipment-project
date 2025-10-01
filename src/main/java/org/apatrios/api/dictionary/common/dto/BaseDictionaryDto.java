package org.apatrios.api.dictionary.common.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apatrios.api.dictionary.component_model.dto.ComponentModelDto;
import org.apatrios.api.dictionary.iot_model.dto.IotModelDto;
import org.apatrios.api.dictionary.model_bike.dto.ModelBikeDto;
import org.apatrios.api.dictionary.operator.dto.OperatorDto;
import org.apatrios.api.dictionary.payment_type.dto.PaymentTypeDto;
import org.apatrios.api.dictionary.point.dto.PointDto;
import org.apatrios.api.dictionary.repair_type.dto.RepairTypeDto;
import org.apatrios.api.dictionary.service.dto.ServiceDto;
import org.apatrios.api.dictionary.service_type.dto.ServiceTypeDto;
import org.apatrios.model.dictoinary.EntityStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ModelBikeDto.class, name = "modelBike"),
        @JsonSubTypes.Type(value = ComponentModelDto.class, name = "componentModel"),
        @JsonSubTypes.Type(value = IotModelDto.class, name = "iotModel"),
        @JsonSubTypes.Type(value = OperatorDto.class, name = "operator"),
        @JsonSubTypes.Type(value = PaymentTypeDto.class, name = "paymentType"),
        @JsonSubTypes.Type(value = PointDto.class, name = "point"),
        @JsonSubTypes.Type(value = RepairTypeDto.class, name = "repairType"),
        @JsonSubTypes.Type(value = ServiceDto.class, name = "service"),
        @JsonSubTypes.Type(value = ServiceTypeDto.class, name = "serviceType"),
})
@Schema(description = "Базовый DTO справочника")
public class BaseDictionaryDto {

    @Schema(description = "Уникальный идентификатор")
    UUID id;

    @Schema(description = "Наименование")
    String name;

    @Schema(description = "Статус")
    EntityStatus status;

    @Schema(description = "Дата создания")
    LocalDateTime createDate;
}