package org.apatrios.api.management.staff.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.Position;
import org.apatrios.model.management.StaffProfile;
import org.apatrios.model.management.StaffStatus;

import javax.validation.constraints.NotNull;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для обновления данных сотрудника")
public class UpdateStaffDto {

    @Schema(description = "Уникальный идентификатор")
    @NotNull
    UUID id;

    @Schema(description = "Контактная информация сотрудника", required = true)
    @NotNull
    StaffProfile staffProfile;

    @Schema(description = "Должность сотрудника", example = "MANAGER", required = true)
    @NotNull
    Position position;

    @Schema(description = "ID Франчайзинговая точка сотрудника", required = true)
    @NotNull
    UUID franchiseeId;

    @Schema(description = "Статус сотрудника", example = "ACTIVE", required = true)
    @NotNull
    StaffStatus status;
}
