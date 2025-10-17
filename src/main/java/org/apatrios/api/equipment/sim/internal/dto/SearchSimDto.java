package org.apatrios.api.equipment.sim.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO поиска Sim-карты")
public class SearchSimDto {
    @Schema(description = "Номер телефона")
    String phoneNumber;

    @Schema(description = "id оператора")
    UUID operatorId;
}