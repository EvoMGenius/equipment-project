package org.apatrios.api.dictionary.common.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apatrios.api.dictionary.dict.dto.DictDto;
import org.apatrios.api.dictionary.model_bike.dto.ModelBikeDto;
import org.apatrios.api.dictionary.purchase_type.dto.PurchaseTypeDto;
import org.apatrios.api.dictionary.rent_type.dto.RentTypeDto;

import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DictDto.class, name = "dict"),
        @JsonSubTypes.Type(value = ModelBikeDto.class, name = "model-bike"),
        @JsonSubTypes.Type(value = PurchaseTypeDto.class, name = "purchase-type"),
        @JsonSubTypes.Type(value = RentTypeDto.class, name = "rent-type")
})
@Schema(description = "Базовый DTO справочника")
public abstract class BaseDictionaryDto {

    @Schema(description = "Уникальный идентификатор")
    UUID id;

    @Schema(description = "Наименование")
    String name;
}