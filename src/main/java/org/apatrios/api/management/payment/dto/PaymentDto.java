package org.apatrios.api.management.payment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.api.dictionary.payment_type.dto.PaymentTypeDto;
import org.apatrios.api.management.company.dto.CompanyDto;
import org.apatrios.model.management.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Schema(description = "DTO для информации об оплате")
public record PaymentDto(

        @Schema(description = "Уникальный идентификатор платежа")
        UUID id,

        @Schema(description = "Способ оплаты")
        PaymentTypeDto paymentType,

        @Schema(description = "Компания")
        CompanyDto company,

        @Schema(description = "Тип оплачиваемой сущности")
        String entityType,

        @Schema(description = "ID оплачиваемой сущности")
        UUID entityId,

        @Schema(description = "Валюта платежа")
        String currency,

        @Schema(description = "Сумма платежа")
        BigDecimal amount,

        @Schema(description = "Дата востребования платежа")
        LocalDateTime dateOfDemand,

        @Schema(description = "Текущий статус платежа (CREATED, PENDING, CANCELED, SUCCEEDED)")
        PaymentStatus status,

        @Schema(description = "Дата создания платежа")
        LocalDateTime createDate,

        @Schema(description = "Дата последнего обновления платежа")
        LocalDateTime updateDate,

        @Schema(description = "Метаданные от платежной системы (например confirm_url)")
        Map<String, String> metadata,

        @Schema(description = "Удален ли")
        Boolean isDeleted
) {}