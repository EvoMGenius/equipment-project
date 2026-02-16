package org.apatrios.api.services.debt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.dict.dto.DictDto;
import org.apatrios.api.management.doc.dto.DocumentDto;
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
@Schema(description = "DTO задолженности")
public class DebtDto {
    @Schema(description = "ID")
    UUID id;

    @Schema(description = "Тип задолженности (Штраф, Просрочка и т.д.)")
    DictDto debtType;

    @Schema(description = "Сумма задолженности", example = "1500.00")
    BigDecimal total;

    @Schema(description = "Описание причины начисления")
    String description;

    @Schema(description = "Статус (Ожидает оплаты, Оплачено, Аннулировано)")
    DebtStatus status;

    @Schema(description = "Связанный документ (акт или счет)")
    DocumentDto document;
}