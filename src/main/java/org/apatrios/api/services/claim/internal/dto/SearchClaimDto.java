package org.apatrios.api.services.claim.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.services.ClaimStatus;

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
@Schema(description = "DTO для поиска претензий")
public class SearchClaimDto {

    @Schema(description = "ID родительской аренды")
    UUID parentRentId;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @Schema(description = "Строка поиска")
    String searchString;

    @Schema(description = "ID типа претензии")
    UUID claimTypeId;

    @Schema(description = "Статус претензии")
    ClaimStatus status;

    @Schema(description = "Комментарий (поиск по содержимому)")
    String note;

    @Schema(description = "Дата начала претензии от")
    LocalDateTime startDateFrom;

    @Schema(description = "Дата начала претензии до")
    LocalDateTime startDateTo;

    @Schema(description = "Дата решения от")
    LocalDateTime endDateFrom;

    @Schema(description = "Дата решения до")
    LocalDateTime endDateTo;

    @Schema(description = "Дата создания от")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания до")
    LocalDateTime createDateTo;

    @Schema(description = "Признак удаления")
    boolean isDeleted;
}
