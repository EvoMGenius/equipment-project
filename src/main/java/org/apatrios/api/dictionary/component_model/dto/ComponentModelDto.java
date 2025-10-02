package org.apatrios.api.dictionary.component_model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.common.dto.BaseDictionaryDto;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "DTO модели компонента")
public class ComponentModelDto extends BaseDictionaryDto {
}
