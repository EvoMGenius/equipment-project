package org.apatrios.api.management.franchisee.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.FranchiseeProfile;
import org.apatrios.model.management.FranchiseeStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для информации о франчайзи")
public class FranchiseeDto {

    @Schema(description = "Уникальный идентификатор")
    UUID id;

    @Schema(description = "Контактная информация франчайзи", required = true)
    FranchiseeProfile franchiseeProfile;

    @Schema(description = "Идентификационный номер налогоплательщика", example = "7701234567", required = true)
    String inn;

    @Schema(description = "Статус франчайзи", example = "ACTIVE", required = true)
    FranchiseeStatus status;

    @Schema(description = "Дата и время создания записи", example = "2025-10-01T12:34:56")
    LocalDateTime createDate;

    @Schema(description = "Дата и время обновления записи", example = "2025-10-02T09:15:00")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления записи", example = "false")
    boolean isDeleted;
}
