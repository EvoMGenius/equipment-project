package org.apatrios.api.management.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.management.CompanyStatus;

import java.time.LocalDateTime;

@Schema(description = "Фильтры для поиска компаний")
public record SearchCompanyDto(

        @Schema(description = "Часть названия организации", example = "Вектор")
        String name,

        @Schema(description = "ИНН (точное совпадение или начало номера)", example = "7701")
        String inn,

        @Schema(description = "Часть адреса", example = "Москва")
        String address,

        @Schema(description = "Часть номера телефона", example = "900")
        String phone,

        @Schema(description = "Электронная почта", example = "vector.ru")
        String email,

        @Schema(description = "Фильтр по статусу")
        CompanyStatus status,

        @Schema(description = "Фильтр по признаку удаления")
        Boolean isDeleted,

        @Schema(description = "Создана ОТ (ГГГГ-ММ-ДДTЧЧ:ММ:СС)")
        LocalDateTime createDateFrom,

        @Schema(description = "Создана ДО (ГГГГ-ММ-ДДTЧЧ:ММ:СС)")
        LocalDateTime createDateTo,

        @Schema(description = "Обновлена ОТ")
        LocalDateTime updateDateFrom,

        @Schema(description = "Обновлена ДО")
        LocalDateTime updateDateTo
) {
}
