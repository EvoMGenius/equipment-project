package org.apatrios.api.services.client.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.services.ClientStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO поиска клиентов")
public class SearchClientDto {

    @Schema(description = "Номер телефона клиента", example = "+79998887766")
    String phone;

    @Schema(description = "Строка поиска")
    String searchString;

    @Schema(description = "Фамилия клиента", example = "Иванов")
    String surname;

    @Schema(description = "Имя клиента", example = "Алексей")
    String name;

    @Schema(description = "Идентификатор франчайзи", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID franchiseeId;

    @Schema(description = "Дата создания (с)", example = "2025-01-01T00:00:00")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания (по)", example = "2025-01-31T23:59:59")
    LocalDateTime createDateTo;

    @Schema(description = "Дата обновления (с)", example = "2025-02-01T00:00:00")
    LocalDateTime updateDateFrom;

    @Schema(description = "Дата обновления (по)", example = "2025-02-28T23:59:59")
    LocalDateTime updateDateTo;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;

    @Schema(description = "Статус")
    ClientStatus status;
}
