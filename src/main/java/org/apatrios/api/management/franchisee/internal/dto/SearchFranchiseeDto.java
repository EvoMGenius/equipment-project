package org.apatrios.api.management.franchisee.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.FranchiseeStatus;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для поиска и фильтрации франчайзи")
public class SearchFranchiseeDto {

    @Schema(description = "Телефон франчайзи", example = "+7 123 456 78 90")
    String phone;

    @Schema(description = "Имя франчайзи", example = "ООО Ромашка")
    String name;

    @Schema(description = "Электронная почта", example = "info@franchisee.com")
    String email;

    @Schema(description = "Адрес франчайзи", example = "г. Москва, ул. Ленина, 1")
    String address;

    @Schema(description = "Идентификационный номер налогоплательщика", example = "7701234567")
    String inn;

    @Schema(description = "Статус франчайзи", example = "ACTIVE")
    FranchiseeStatus status;

    @Schema(description = "Дата создания от", example = "2025-10-01T00:00:00")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания до", example = "2025-10-31T23:59:59")
    LocalDateTime createDateTo;

    @Schema(description = "Дата обновления от", example = "2025-10-01T00:00:00")
    LocalDateTime updateDateFrom;

    @Schema(description = "Дата обновления до", example = "2025-10-31T23:59:59")
    LocalDateTime updateDateTo;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;
}
