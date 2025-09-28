package org.apatrios.controller.bike.internal.dto;

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
@Schema(description = "DTO для создания велосипеда")
public class CreateBikeDto {

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

    @NotBlank
    @Schema(description = "Марка/модель моторного колеса")
    String motorWheel;

    @NotNull
    @Schema(description = "Идентификатор привязанного IoT-устройства")
    UUID iotId;

    @NotBlank
    @Schema(description = "Комментарий или дополнительная информация")
    String comment;
}
