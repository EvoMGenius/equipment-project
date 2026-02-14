package org.apatrios.api.dictionary.model_bike.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto;

import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Модель поиска велосипеда")
public class SearchModelBikeDto extends BaseDictionarySearchDto {
    String weight;
    String maxLoad;
    String range;
    String maxSpeed;
    List<UUID> photoIds;
}
