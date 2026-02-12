package org.apatrios.api.services.rent.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для инициации новой аренды")
public class CreateRentDto {

    @Schema(description = "ID пользователя")
    UUID userId;

    @Schema(description = "ID велосипеда")
    UUID bikeId;

    @Schema(description = "ID точки выдачи")
    UUID pointId;

    @Schema(description = "Список ID выбранной экипировки")
    List<UUID> outfitIds;

    @Schema(description = "Планируемая дата начала")
    LocalDateTime startDate;

    @Schema(description = "Планируемая дата окончания")
    LocalDateTime endDate;

    @Schema(description = "ID начального статуса")
    UUID statusId;
}