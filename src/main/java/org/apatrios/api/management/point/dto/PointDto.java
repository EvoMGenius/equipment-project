package org.apatrios.api.management.point.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.dict.dto.DictDto;
import org.apatrios.api.equipment.status.dto.StatusDto;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для информации о точке")
public class PointDto {

    @Schema(description = "Тип точки")
    DictDto pointType;

    @Schema(description = "Наименование точки", example = "Парковка у ТЦ 'Центральный'")
    String name;

    @Schema(description = "Контактный номер телефона точки", example = "+7 (999) 000-00-00")
    String number;

    @Schema(description = "Физический адрес расположения")
    String address;

    @Schema(description = "Режим работы точки", example = "Пн-Пт: 09:00 - 21:00, Сб-Вс: выходной")
    String workTime;

    @Schema(description = "Текущий статус точки (Активна, Временно закрыта, Ремонт)")
    StatusDto status;
}
