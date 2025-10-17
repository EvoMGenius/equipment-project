package org.apatrios.api.equipment.sim.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.operator.dto.OperatorDto;
import org.apatrios.model.dictoinary.Operator;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO Sim-карты")
public class SimDto {

    @Schema(description = "Уникальный идентификатор")
    UUID id;

    @Schema(description = "Номер телефона")
    String phoneNumber;

    @Schema(description = "Оператор")
    OperatorDto operator;
}