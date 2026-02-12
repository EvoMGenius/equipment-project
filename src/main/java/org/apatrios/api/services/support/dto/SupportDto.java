package org.apatrios.api.services.support.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.dict.dto.DictDto;
import org.apatrios.api.equipment.status.dto.StatusDto;
import org.apatrios.api.services.photo.dto.PhotoDto;
import org.apatrios.api.services.repair.dto.RepairDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO обращения в поддержку")
public class SupportDto {
    UUID id;

    @Schema(description = "Дата создания")
    LocalDateTime createDate;

    @Schema(description = "Тип обращения (справочник)")
    DictDto type;

    @Schema(description = "Описание проблемы")
    String description;

    @Schema(description = "Список фото")
    List<PhotoDto> photo;

    @Schema(description = "Связанный ремонт (если есть)")
    RepairDto childRepair;

    @Schema(description = "Статус тикета")
    StatusDto status;
}