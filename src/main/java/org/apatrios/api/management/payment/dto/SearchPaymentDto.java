package org.apatrios.api.management.payment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.management.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "DTO для поиска и фильтрации платежей")
public record SearchPaymentDto(

        @Schema(description = "ID компании, к которой относится платеж")
        UUID companyId,

        @Schema(description = "ID типа платежа (например: карта, СБП, электронный кошелек)")
        UUID paymentTypeId,

        @Schema(description = "Валюта платежа", example = "RUB")
        String currency,

        @Schema(description = "Минимальная сумма платежа", example = "100.00")
        BigDecimal amountFrom,

        @Schema(description = "Максимальная сумма платежа", example = "10000.00")
        BigDecimal amountTo,

        @Schema(description = "ID оплачиваемой сущности (например аренды, штрафа или депозита)")
        UUID entityId,

        @Schema(description = "Тип оплачиваемой сущности (например RENT, FINE, DEPOSIT)")
        String entityType,

        @Schema(description = "Статус платежа (CREATED, PENDING, CANCELED, SUCCEEDED)")
        PaymentStatus status,

        @Schema(description = "Флаг мягкого удаления записи")
        Boolean isDeleted,

        @Schema(description = "Дата востребования платежа от")
        LocalDateTime dateOfDemandFrom,

        @Schema(description = "Дата востребования платежа до")
        LocalDateTime dateOfDemandTo,

        @Schema(description = "Дата создания платежа от")
        LocalDateTime createDateFrom,

        @Schema(description = "Дата создания платежа до")
        LocalDateTime createDateTo,

        @Schema(description = "Дата последнего обновления платежа от")
        LocalDateTime updateDateFrom,

        @Schema(description = "Дата последнего обновления платежа до")
        LocalDateTime updateDateTo
) {}