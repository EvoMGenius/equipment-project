package org.apatrios.api.services.repair.dto;

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
@Schema(description = "DTO для создания новой заявки на ремонт")
public class CreateRepairDto {

    @Schema(description = "ID типа ремонта из справочника Dict")
    UUID fixTypeId;

    @Schema(description = "Описание проблемы")
    String problem;

    @Schema(description = "ID сервисного центра (Point)")
    UUID pointId;

    @Schema(description = "ID начального статуса")
    UUID statusId;
}