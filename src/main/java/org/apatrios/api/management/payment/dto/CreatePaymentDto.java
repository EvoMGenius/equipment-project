package org.apatrios.api.management.payment.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "DTO для создания нового платежа")
public record CreatePaymentDto(

        @NotNull
        @Schema(description = "ID типа платежа")
        UUID paymentTypeId,

        @NotNull
        @Schema(description = "ID компании")
        UUID companyId,

        @NotBlank
        @Schema(description = "Валюта платежа", example = "RUB")
        String currency,

        @NotNull
        @Schema(description = "Сумма платежа", example = "450.00")
        BigDecimal amount,

        @NotNull
        @Schema(description = "ID оплачиваемой сущности (например аренды)")
        UUID entityId,

        @NotBlank
        @Schema(description = "Тип оплачиваемой сущности (RENT, FINE, DEPOSIT)")
        String entityType,

        @Schema(description = "Дата востребования платежа")
        LocalDateTime dateOfDemand
) {}