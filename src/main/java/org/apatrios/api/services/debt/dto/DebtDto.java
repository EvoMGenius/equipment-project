package org.apatrios.api.services.debt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.api.management.doc.dto.DocumentDto;
import org.apatrios.model.services.DebtStatus;

import java.math.BigDecimal;
import java.util.UUID;

@Schema(description = "DTO задолженности")
public record DebtDto(
        @Schema(description = "ID")
        UUID id,

        @Schema(description = "Тип задолженности (Штраф, Просрочка и т.д.)")
        String debtType,

        @Schema(description = "Сумма задолженности", example = "1500.00")
        BigDecimal total,

        @Schema(description = "Описание причины начисления")
        String description,

        @Schema(description = "Статус (Ожидает оплаты, Оплачено, Аннулировано)")
        DebtStatus status,

        @Schema(description = "Связанный документ (акт или счет)")
        DocumentDto document
) {}