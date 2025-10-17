package org.apatrios.api.services.request.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.services.RequestStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для поиска запросов с фильтрацией")
public class SearchRequestDto {

    @Schema(description = "Телефон клиента", example = "+79991234567")
    String phone;

    @Schema(description = "Фамилия клиента", example = "Иванов")
    String surname;

    @Schema(description = "Имя клиента", example = "Иван")
    String name;

    @Schema(description = "ID типа услуги", example = "111e8400-e29b-41d4-a716-446655440000")
    UUID serviceTypeId;

    @Schema(description = "ID модели велосипеда", example = "222e8400-e29b-41d4-a716-446655440000")
    UUID modelBikeId;

    @Schema(description = "Комментарий к запросу", example = "Срочный ремонт")
    String note;

    @Schema(description = "ID клиента", example = "333e8400-e29b-41d4-a716-446655440000")
    UUID clientId;

    @Schema(description = "Статус запроса", example = "NEW")
    RequestStatus status;

    @Schema(description = "Начало диапазона фильтрации по дате создания", example = "2025-10-01T00:00:00")
    LocalDateTime createDateFrom;

    @Schema(description = "Конец диапазона фильтрации по дате создания", example = "2025-10-02T23:59:59")
    LocalDateTime createDateTo;

    @Schema(description = "Начало диапазона фильтрации по дате обновления", example = "2025-10-01T00:00:00")
    LocalDateTime updateDateFrom;

    @Schema(description = "Конец диапазона фильтрации по дате обновления", example = "2025-10-02T23:59:59")
    LocalDateTime updateDateTo;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;

    @Schema(description = "Причина отказа ID")
    UUID rejectionReasonId;

    @Schema(description = "Доп написание для причины отказа")
    String rejectNote;
}
