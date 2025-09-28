package org.apatrios.controller.simbalance.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.controller.sim.internal.dto.SimDto;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO баланса Sim-карты")
public class SimBalanceDto {

    @Schema(description = "Уникальный идентификатор")
    UUID id;

    @Schema(description = "Баланс")
    Integer value;

    @Schema(description = "Sim-карта")
    SimDto sim;

    @Schema(description = "Дата создания")
    LocalDateTime createDate;
}