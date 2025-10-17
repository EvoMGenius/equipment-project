package org.apatrios.api.services.repair.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для создания ремонта")
public class CreateRepairDto {

    @NotNull
    @Schema(description = "ID объекта (велосипед, экипировка, запчасть)", example = "222e8400-e29b-41d4-a716-446655440000")
    UUID objectId;

    @NotNull
    @Schema(description = "Тип ремонта id")
    UUID repairTypeId;

    @Schema(description = "ID исполнителя", example = "333e8400-e29b-41d4-a716-446655440000")
    UUID staffId;

    @Schema(description = "Выполненные работы", example = "Замена тормозных колодок")
    String description;

    @Schema(description = "Комментарий", example = "Срочный ремонт")
    String comment;
}
