package org.apatrios.api.management.staff.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.StaffProfile;
import org.apatrios.model.management.Position;
import org.apatrios.model.management.StaffStatus;
import org.apatrios.model.management.Franchisee;

import static lombok.AccessLevel.PRIVATE;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для информации о сотруднике")
public class StaffDto {

    @Schema(description = "Уникальный идентификатор")
    UUID id;

    @Schema(description = "Контактная информация сотрудника", required = true)
    StaffProfile staffProfile;

    @Schema(description = "Должность сотрудника", example = "MANAGER", required = true)
    Position position;

    @Schema(description = "Франчайзинговая точка сотрудника", required = true)
    Franchisee franchisee;

    @Schema(description = "Статус сотрудника", example = "ACTIVE", required = true)
    StaffStatus status;

    @Schema(description = "Дата и время создания", example = "2025-10-01T12:34:56")
    LocalDateTime createDate;

    @Schema(description = "Дата и время обновления", example = "2025-10-02T09:15:00")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;
}
