package org.apatrios.api.dictionary.common.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apatrios.api.dictionary.dict.dto.DictDto;
import org.apatrios.api.dictionary.model_bike.dto.ModelBikeDto;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DictDto.class, name = "dict"),
        @JsonSubTypes.Type(value = ModelBikeDto.class, name = "model-bike")
})
@Schema(description = "Базовый DTO поиска справочника")
public abstract class BaseDictionarySearchDto {

    @Schema(description = "Наименование")
    String name;
}
