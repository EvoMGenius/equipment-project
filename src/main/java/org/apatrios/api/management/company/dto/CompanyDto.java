package org.apatrios.api.management.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.management.CompanyStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Данные компании")
public record CompanyDto(

        @Schema(description = "ID")
        UUID id,

        @Schema(description = "Название организации", example = "ООО 'Ромашка'")
        String name,

        @Schema(description = "ИНН", example = "7701234567")
        String inn,

        @Schema(description = "Юридический адрес", example = "г. Москва, ул. Пушкина, д. 10")
        String address,

        @Schema(description = "Контактный телефон", example = "+79991234567")
        String phone,

        @Schema(description = "Электронная почта", example = "info@romashka.ru")
        String email,

        @Schema(description = "Текущий статус компании")
        CompanyStatus status,

        @Schema(description = "Дата и время создания записи")
        LocalDateTime createDate,

        @Schema(description = "Дата и время последнего обновления")
        LocalDateTime updateDate,

        @Schema(description = "Признак удаления", example = "false")
        Boolean isDeleted
) {
}