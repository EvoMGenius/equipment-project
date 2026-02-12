package org.apatrios.api.services.repair.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.dict.dto.DictDto;
import org.apatrios.api.equipment.status.dto.StatusDto;
import org.apatrios.api.management.point.dto.PointDto;
import org.apatrios.api.services.photo.dto.PhotoDto;

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
@Schema(description = "DTO с полной информацией о ремонте")
public class RepairDto {

    @Schema(description = "ID записи ремонта")
    UUID id;

    @Schema(description = "Номер заявки на ремонт", example = "REP-2026-005")
    String number;

    @Schema(description = "Тип произведенного ремонта (из справочника)")
    DictDto fixType;

    @Schema(description = "Проблема со слов клиента")
    String problem;

    @Schema(description = "Текущий статус ремонта")
    StatusDto status;

    @Schema(description = "Дата и время создания заявки")
    LocalDateTime createDate;

    @Schema(description = "Сервисный центр (пункт)")
    PointDto point;

    @Schema(description = "Список прикрепленных фотографий")
    List<PhotoDto> photos;
}