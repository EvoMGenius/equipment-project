package org.apatrios.api.equipment.simbalance.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchSimBalanceDto {

    @Schema(description = "Баланс")
    Integer value;

    @Schema(description = "id Sim-карты")
    UUID simId;

    @Schema(description = "Дата создания начало")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания конец")
    LocalDateTime createDateTo;

    @Schema(description = "Дата обновления начало")
    LocalDateTime updateDateFrom;

    @Schema(description = "Дата обновления начало")
    LocalDateTime updateDateTo;

    @Schema(description = "Признак удаления")
    boolean isDeleted;
}