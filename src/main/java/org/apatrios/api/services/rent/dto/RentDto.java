package org.apatrios.api.services.rent.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.equipment.bike.dto.BikeDto;
import org.apatrios.api.equipment.outfit.dto.OutfitDto;
import org.apatrios.api.management.doc.dto.DocumentDto;
import org.apatrios.api.management.point.dto.PointDto;
import org.apatrios.api.services.debt.dto.DebtDto;
import org.apatrios.model.services.RentStatus;

import java.math.BigDecimal;
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
@Schema(description = "DTO аренды")
public class RentDto {

    @Schema(description = "ID аренды")
    UUID id;

    @Schema(description = "Номер договора аренды", example = "RENT-2026-001")
    String number;

    @Schema(description = "Текущий статус аренды")
    RentStatus status;

    @Schema(description = "ID пользователя-арендатора")
    UUID userId;

    @Schema(description = "Информация о байке")
    BikeDto bike;

    @Schema(description = "Пункт выдачи/возврата")
    PointDto point;

    @Schema(description = "Дата начала")
    LocalDateTime startDate;

    @Schema(description = "Дата окончания")
    LocalDateTime endDate;

    @Schema(description = "Итоговая стоимость", example = "5000")
    Integer total;

    @Schema(description = "Количество прошедших дней")
    Integer currentDays;

    @Schema(description = "Просрочка (в днях)")
    Integer delay;

    @Schema(description = "Стоимость просрочки")
    BigDecimal delayCost;

    @Schema(description = "Список экипировки")
    List<OutfitDto> outfits;

    @Schema(description = "Связанные документы (договор, акты)")
    List<DocumentDto> documents;

    @Schema(description = "Задолженности по аренде")
    List<DebtDto> debts;
}
