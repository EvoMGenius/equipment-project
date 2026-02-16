package org.apatrios.api.dictionary.model_bike.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.common.dto.BaseDictionaryDto;
import org.apatrios.model.services.Photo;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Модель велосипеда")
public class ModelBikeDto extends BaseDictionaryDto {
    String weight;
    String maxLoad;
    String range;
    String maxSpeed;
    List<Photo> photo;
}
