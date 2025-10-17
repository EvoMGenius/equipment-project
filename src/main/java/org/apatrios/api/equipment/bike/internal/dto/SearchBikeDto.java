package org.apatrios.api.equipment.bike.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.equipment.BikeStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO поиска велосипеда")
public class SearchBikeDto {

    @Schema(description = "Идентификатор модели велосипеда")
    UUID modelBikeId;

    @Schema(description = "Франчизи")
    UUID franchiseeId;

    @Schema(description = "Порядковый номер внутри модели")
    Integer seqNumber;

    @Schema(description = "Инвентарный номер велосипеда")
    Integer invNumber;

    @Schema(description = "VIN — уникальный идентификатор транспортного средства")
    String vin;

    @Schema(description = "Марка/модель моторного колеса")
    String motorWheel;

    @Schema(description = "Идентификатор привязанного IoT-устройства")
    UUID iotId;

    @Schema(description = "Статус велосипеда")
    BikeStatus status;

    @Schema(description = "Комментарий или дополнительная информация")
    String comment;

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
