package org.apatrios.api.services.debt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.services.DebtStatus;

import java.math.BigDecimal;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO поиска задолженностей")
public class SearchDebtDto {
    @Schema(description = "ID типа задолженности")
    UUID debtTypeId;

    @Schema(description = "Сумма начисления")
    BigDecimal total;

    @Schema(description = "Описание за что начислена")
    String description;

    @Schema(description = "Статус (Ожидает оплаты, Оплачено, Аннулировано)")
    DebtStatus status;

    @Schema(description = "ID связанного документа (если есть)")
    UUID documentId;
}