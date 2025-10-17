package org.apatrios.api.equipment.sim.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

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