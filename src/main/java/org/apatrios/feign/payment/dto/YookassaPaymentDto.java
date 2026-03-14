package org.apatrios.feign.payment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Map;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record YookassaPaymentDto(
        @JsonProperty("id") String id,
        @JsonProperty("payment_id") String paymentId,
        @JsonProperty("status") String status,
        @JsonProperty("amount") YookassaAmountDto amount,
        @JsonProperty("income_amount") YookassaIncomeAmountDto incomeAmount,
        @JsonProperty("confirmation") YookassaConfirmationDto confirmation,
        @JsonProperty("metadata") Map<String, Object> metadata
) {}