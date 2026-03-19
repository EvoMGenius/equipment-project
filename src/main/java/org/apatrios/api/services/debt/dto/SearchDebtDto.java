package org.apatrios.api.services.debt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.services.DebtStatus;

import java.math.BigDecimal;
import java.util.UUID;

@Schema(description = "DTO поиска задолженностей")
public record SearchDebtDto (
    @Schema(description = "тип задолженности")
    String debtType,

    @Schema(description = "Сумма начисления")
    BigDecimal total,

    @Schema(description = "Описание за что начислена")
    String description,

    @Schema(description = "Статус (Ожидает оплаты, Оплачено, Аннулировано)")
    DebtStatus status,

    @Schema(description = "ID связанного документа (если есть)")
    UUID documentId
){}