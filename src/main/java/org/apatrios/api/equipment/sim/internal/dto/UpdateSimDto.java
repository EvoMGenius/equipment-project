package org.apatrios.api.equipment.sim.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO обновления Sim-карты")
public class UpdateSimDto {
    @NotNull
    @Schema(description = "Уникальный идентификатор")
    UUID id;

    @NotBlank
    @Schema(description = "Номер телефона")
    String phoneNumber;

    @NotNull
    @Schema(description = "id оператора")
    UUID operatorId;
}