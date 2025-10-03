package org.apatrios.api.services.request.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.services.client.internal.dto.ClientDto;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.dictoinary.ServiceType;
import org.apatrios.model.services.RequestProfile;
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
@Schema(description = "DTO запроса")
public class RequestDto {

    @Schema(description = "Уникальный идентификатор запроса", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id;

    @Schema(description = "Контактная информация клиента")
    RequestProfile requestProfile;

    @Schema(description = "Тип услуги", example = "REPAIR")
    ServiceType serviceType;

    @Schema(description = "Модель велосипеда", example = "ModelX")
    ModelBike modelBike;

    @Schema(description = "Комментарий к запросу", example = "Необходимо срочно")
    String note;

    @Schema(description = "Клиент")
    ClientDto client;

    @Schema(description = "Статус запроса", example = "NEW")
    RequestStatus status;

    @Schema(description = "Дата создания", example = "2025-10-01T10:00:00")
    LocalDateTime createDate;

    @Schema(description = "Дата обновления", example = "2025-10-02T15:30:00")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;
}
