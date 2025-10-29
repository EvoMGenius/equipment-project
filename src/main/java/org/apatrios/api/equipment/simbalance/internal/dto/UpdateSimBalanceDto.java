package org.apatrios.api.equipment.simbalance.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSimBalanceDto {

    @NotNull
    @Schema(description = "Уникальный идентификатор")
    UUID id;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @NotNull
    @Schema(description = "Баланс")
    Integer value;

    @NotNull
    @Schema(description = "id Sim-карты")
    UUID simId;
}