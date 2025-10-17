package org.apatrios.api.services.rent.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.management.staff.internal.dto.StaffDto;
import org.apatrios.api.services.client.internal.dto.ClientDto;
import org.apatrios.api.services.request.internal.dto.RequestDto;
import org.apatrios.model.management.Payment;
import org.apatrios.model.services.RentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO аренды")
public class RentDto {

    @Schema(description = "Уникальный идентификатор аренды", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id;

    @Schema(description = "Сотрудник")
    StaffDto staff;

    @Schema(description = "Клиент")
    ClientDto client;

    @Schema(description = "Дата и время начала аренды", example = "2025-10-01T10:00:00")
    LocalDateTime rentStart;

    @Schema(description = "Дата и время окончания аренды", example = "2025-10-01T14:00:00")
    LocalDateTime rentEnd;

    @Schema(description = "Статус аренды", example = "ACTIVE")
    RentStatus rentStatus;

    @Schema(description = "Оплата", required = true)
    Payment payment;

    @Schema(description = "Комментарий администратора")
    String comment;

    @Schema(description = "Родительская аренда")
    RentDto parentRent;

    @Schema(description = "Родительская заявка")
    RequestDto parentRequest;

    @Schema(description = "Дата создания", example = "2025-09-01T08:30:00")
    LocalDateTime createDate;

    @Schema(description = "Дата обновления", example = "2025-09-10T12:45:00")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;
}
