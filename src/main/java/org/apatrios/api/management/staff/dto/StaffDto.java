package org.apatrios.api.management.staff.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.management.StaffStatus;
import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Данные сотрудника")
public record StaffDto(
        @Schema(description = "ID")
        UUID id,

        @Schema(description = "Фамилия")
        String surname,

        @Schema(description = "Имя")
        String name,

        @Schema(description = "Должность")
        String position,

        @Schema(description = "ID компании")
        UUID companyId,

        @Schema(description = "Телефон")
        String phone,

        @Schema(description = "Email")
        String email,

        @Schema(description = "Статус")
        StaffStatus status,

        @Schema(description = "Дата создания")
        LocalDateTime createDate,

        @Schema(description = "Дата обновления")
        LocalDateTime updateDate,

        @Schema(description = "Удален ли")
        Boolean isDeleted
) {}