package org.apatrios.api.equipment.bike.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.equipment.BikeStatus;

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
@Schema(description = "DTO обновления велосипеда")
public class UpdateBikeDto {

    @NotNull
    @Schema(description = "Уникальный идентификатор велосипеда")
    UUID id;

    @NotNull
    @Schema(description = "Франчизи ID")
    UUID franchiseeId;

    @NotNull
    @Schema(description = "Идентификатор модели велосипеда")
    UUID modelBikeId;

    @NotNull
    @Schema(description = "Порядковый номер внутри модели")
    Integer seqNumber;

    @NotNull
    @Schema(description = "Инвентарный номер велосипеда")
    Integer invNumber;

    @NotBlank
    @Schema(description = "VIN — уникальный идентификатор транспортного средства")
    String vin;

    @NotNull
    @Schema(description = "Марка/модель моторного колеса")
    String motorWheel;

    @NotNull
    @Schema(description = "Идентификатор привязанного IoT-устройства")
    UUID iotId;

    @NotBlank
    @Schema(description = "Статус велосипеда")
    BikeStatus status;

    @Schema(description = "Комментарий или дополнительная информация")
    String comment;
}
