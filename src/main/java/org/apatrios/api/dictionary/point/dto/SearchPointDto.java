package org.apatrios.api.dictionary.point.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "DTO модели поиска точек")
public class SearchPointDto extends BaseDictionarySearchDto {
}
