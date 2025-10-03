package org.apatrios.api.services.repair.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.services.RepairStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для обновления ремонта")
public class UpdateRepairDto {

    @NotNull
    @Schema(description = "ID ремонта", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id;

    @NotNull
    @Schema(description = "ID объекта (велосипед, экипировка, запчасть)", example = "222e8400-e29b-41d4-a716-446655440000")
    UUID objectId;

    @NotNull
    @Schema(description = "Тип ремонта id")
    UUID repairTypeId;

    @NotNull
    @Schema(description = "ID исполнителя", example = "333e8400-e29b-41d4-a716-446655440000")
    UUID staffId;

    @NotBlank
    @Schema(description = "Выполненные работы", example = "Замена тормозных колодок")
    String description;

    @Schema(description = "Статус ремонта", example = "COMPLETED")
    RepairStatus status;

    @Schema(description = "Дата окончания ремонта", example = "2025-10-02T15:30:00")
    LocalDateTime dateEnd;

    @Schema(description = "Комментарий", example = "Ремонт завершен")
    String comment;
}
