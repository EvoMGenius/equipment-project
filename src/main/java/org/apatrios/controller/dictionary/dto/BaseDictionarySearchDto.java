package org.apatrios.controller.dictionary.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.apatrios.model.dictoinary.EntityStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO базового поиска справочника")
public class BaseDictionarySearchDto {

    @Schema(description = "Наименование")
    String name;

    @Schema(description = "Статус")
    EntityStatus status;
}
