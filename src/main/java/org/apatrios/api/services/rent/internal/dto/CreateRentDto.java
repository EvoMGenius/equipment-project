package org.apatrios.api.services.rent.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для создания аренды")
public class CreateRentDto {

    @NotNull
    @Schema(description = "ID администратора", required = true)
    UUID staffId;

    @NotNull
    @Schema(description = "ID клиента", required = true)
    UUID clientId;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @NotNull
    @Schema(description = "Дата начала аренды", example = "2025-10-01T10:00:00", required = true)
    LocalDateTime rentStart;

    @NotNull
    @Schema(description = "Дата окончания аренды", example = "2025-10-01T14:00:00", required = true)
    LocalDateTime rentEnd;

    @Schema(description = "Оплата")
    UUID paymentId;

    @Schema(description = "Комментарий администратора")
    String comment;

    @Schema(description = "ID родительской аренды")
    UUID parentRentId;

    @Schema(description = "ID родительской заявки")
    UUID parentRequestId;

    @Schema(description = "ID партнеры")
    UUID partnerId;

    @Schema(description = "ID тарифа")
    UUID tariffId;
}
