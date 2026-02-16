package org.apatrios.api.services.support.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для создания обращения")
public class CreateSupportDto {
    @Schema(description = "ID типа обращения")
    UUID typeId;

    @Schema(description = "Текст обращения")
    String description;

    @Schema(description = "ID связанного ремонта")
    UUID childRepairId;
}