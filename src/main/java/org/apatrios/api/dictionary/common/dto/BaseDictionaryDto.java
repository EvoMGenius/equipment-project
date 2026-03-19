package org.apatrios.api.dictionary.common.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apatrios.api.dictionary.doc_type.dto.DocTypeDto;
import org.apatrios.api.dictionary.iot_model.dto.IotModelDto;
import org.apatrios.api.dictionary.model_bike.dto.ModelBikeDto;
import org.apatrios.api.dictionary.payment_type.dto.PaymentTypeDto;
import org.apatrios.api.dictionary.point_type.dto.PointTypeDto;
import org.apatrios.api.dictionary.rent_type.dto.RentTypeDto;
import org.apatrios.api.dictionary.tariff_type.dto.TariffTypeDto;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ModelBikeDto.class, name = "model_bike"),
        @JsonSubTypes.Type(value = PaymentTypeDto.class, name = "payment_type"),
        @JsonSubTypes.Type(value = RentTypeDto.class, name = "rent_type"),
        @JsonSubTypes.Type(value = PointTypeDto.class, name = "point_type"),
        @JsonSubTypes.Type(value = IotModelDto.class, name = "iot_model"),
        @JsonSubTypes.Type(value = DocTypeDto.class, name = "doc_type"),
        @JsonSubTypes.Type(value = TariffTypeDto.class, name = "tariff_type")
})
@Schema(description = "Базовый DTO справочника")
public abstract class BaseDictionaryDto {

    @NonNull
    @Schema(description = "Уникальный идентификатор")
    UUID id;

    @NotBlank
    @Schema(description = "Наименование")
    String name;
}