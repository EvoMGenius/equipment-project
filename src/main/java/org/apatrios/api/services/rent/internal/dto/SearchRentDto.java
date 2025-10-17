package org.apatrios.api.services.rent.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
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
@Schema(description = "DTO поиска аренды")
public class SearchRentDto {

    @Schema(description = "ID администратора", example = "111e8400-e29b-41d4-a716-446655440000")
    UUID staffId;

    @Schema(description = "Дата начала аренды", example = "2025-10-01T10:00:00")
    LocalDateTime rentStart;

    @Schema(description = "Дата окончания аренды", example = "2025-10-01T14:00:00")
    LocalDateTime rentEnd;

    @Schema(description = "Статус аренды", example = "ACTIVE")
    RentStatus rentStatus;

    @Schema(description = "ID клиента", example = "222e8400-e29b-41d4-a716-446655440000")
    UUID clientId;

    @Schema(description = "Оплата", required = true)
    UUID paymentId;

    @Schema(description = "Комментарий администратора", example = "Аренда для постоянного клиента")
    String comment;

    @Schema(description = "ID родительской аренды", example = "333e8400-e29b-41d4-a716-446655440000")
    UUID parentRentId;

    @Schema(description = "ID родительской заявки", example = "444e8400-e29b-41d4-a716-446655440000")
    UUID parentRequestId;

    @Schema(description = "Дата создания (с)", example = "2025-09-01T00:00:00")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания (по)", example = "2025-09-30T23:59:59")
    LocalDateTime createDateTo;

    @Schema(description = "Дата обновления (с)", example = "2025-10-01T00:00:00")
    LocalDateTime updateDateFrom;

    @Schema(description = "Дата обновления (по)", example = "2025-10-15T23:59:59")
    LocalDateTime updateDateTo;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;
}
