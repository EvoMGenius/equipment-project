package org.apatrios.api.services.rent.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.PaymentStatus;
import org.apatrios.model.services.RentStatus;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для обновления аренды")
public class UpdateRentDto {

    @NotNull
    @Schema(description = "Уникальный идентификатор аренды", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id;

    @NotNull
    @Schema(description = "ID администратора", required = true)
    UUID staffId;

    @NotNull
    @Schema(description = "ID клиента", required = true)
    UUID clientId;

    @NotNull
    @Schema(description = "Дата начала аренды", example = "2025-10-01T10:00:00", required = true)
    LocalDateTime rentStart;

    @NotNull
    @Schema(description = "Дата окончания аренды", example = "2025-10-01T14:00:00", required = true)
    LocalDateTime rentEnd;

    @NotNull
    @Schema(description = "Статус аренды", example = "COMPLETED", required = true)
    RentStatus rentStatus;

    @NotNull
    @Schema(description = "Оплата", required = true)
    UUID paymentId;

    @Schema(description = "Комментарий администратора")
    String comment;

    @Schema(description = "ID родительской аренды")
    UUID parentRentId;

    @Schema(description = "ID родительской заявки")
    UUID parentRequestId;
}
