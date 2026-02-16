package org.apatrios.api.services.support.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.services.SupportStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO поиска обращений")
public class SearchSupportDto {
    @Schema(description = "Тип обращения (справочник) ID")
    UUID typeId;

    @Schema(description = "Статус тикета")
    SupportStatus status;

    @Schema(description = "Дата создания от")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания до")
    LocalDateTime createDateTo;
}