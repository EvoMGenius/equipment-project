package org.apatrios.api.services.client.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.management.franchisee.internal.dto.FranchiseeDto;
import org.apatrios.model.services.ClientProfile;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO клиента")
public class ClientDto {

    @Schema(description = "Уникальный идентификатор клиента", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id;

    @Schema(description = "Контактная информация клиента")
    ClientProfile clientProfile;

    @Schema(description = "Компания (франчайзи)")
    FranchiseeDto franchisee;

    @Schema(description = "Дата создания", example = "2025-10-01T12:00:00")
    LocalDateTime createDate;

    @Schema(description = "Дата обновления", example = "2025-10-02T15:30:00")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;
}
