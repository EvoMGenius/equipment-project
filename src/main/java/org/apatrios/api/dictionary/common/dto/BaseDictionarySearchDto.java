package org.apatrios.api.dictionary.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Базовый DTO поиска справочника")
public abstract class BaseDictionarySearchDto {

    @Schema(description = "Наименование")
    String name;
}
