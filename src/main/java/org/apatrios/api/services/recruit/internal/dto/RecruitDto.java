package org.apatrios.api.services.recruit.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.service_dictionary.dto.ServiceDictionaryDto;
import org.apatrios.api.services.client.internal.dto.ClientDto;
import org.apatrios.model.dictoinary.ServiceDictionary;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO набора")
public class RecruitDto {

    @Schema(description = "Уникальный идентификатор", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id;

    @Schema(description = "Клиент")
    ClientDto client;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @Schema(description = "Дата создания записи", example = "2025-02-01T10:15:30")
    LocalDateTime createDate;

    @Schema(description = "Дата обновления записи", example = "2025-02-15T12:45:00")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;
}
