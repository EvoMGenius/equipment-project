package org.apatrios.controller.iot.internal.dto;

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
@Schema(description = "DTO создания IoT-устройств")
public class CreateIotDto {
    @NotNull
    @Schema(description = "id модели IoT-устройства")
    UUID iotModelId;

    @NotBlank
    @Schema(description = "Инвентарный номер IoT-устройства")
    String invNumber;

    @NotNull
    @Schema(description = "id SIM-карты")
    UUID simId;


    @Schema(description = "Комментарий или примечание", example = "Устройство установлено на велосипед №12")
    String comment;
}