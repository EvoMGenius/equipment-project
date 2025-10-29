package org.apatrios.api.services.repair.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.repair_type.dto.RepairTypeDto;
import org.apatrios.api.management.staff.internal.dto.StaffDto;
import org.apatrios.model.dictoinary.RepairType;
import org.apatrios.model.services.RepairStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO ремонта")
public class RepairDto {

    @Schema(description = "Уникальный идентификатор", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @Schema(description = "ID велосипеда, экипировки или запчасти", example = "222e8400-e29b-41d4-a716-446655440000")
    UUID objectId;

    @Schema(description = "Тип ремонта")
    RepairTypeDto repairType;

    @Schema(description = "Исполнитель")
    StaffDto staff;

    @Schema(description = "Выполненные работы", example = "Замена тормозных колодок")
    String description;

    @Schema(description = "Статус ремонта", example = "IN_PROGRESS")
    RepairStatus status;

    @Schema(description = "Дата создания записи", example = "2025-10-01T10:00:00")
    LocalDateTime createDate;

    @Schema(description = "Дата окончания ремонта", example = "2025-10-02T15:30:00")
    LocalDateTime dateEnd;

    @Schema(description = "Дата обновления записи", example = "2025-10-02T15:30:00")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;

    @Schema(description = "Комментарий", example = "Клиент запросил срочный ремонт")
    String comment;
}
