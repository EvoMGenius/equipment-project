package org.apatrios.api.management.staff.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.management.StaffStatus;
import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Фильтры для поиска сотрудников")
public record SearchStaffDto(
        @Schema(description = "Поиск по фамилии")
        String surname,

        @Schema(description = "Поиск по имени")
        String name,

        @Schema(description = "Поиск по должности")
        String position,

        @Schema(description = "Фильтр по конкретной компании")
        UUID companyId,

        @Schema(description = "Фильтр по статусу")
        StaffStatus status,

        @Schema(description = "Показывать только удаленных/активных")
        Boolean isDeleted,

        @Schema(description = "Дата создания ОТ")
        LocalDateTime createDateFrom,

        @Schema(description = "Дата создания ДО")
        LocalDateTime createDateTo
) {}