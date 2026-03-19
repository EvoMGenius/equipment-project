package org.apatrios.feign.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Builder
public record YookassaIncomeAmountDto(
        @JsonProperty("value") BigDecimal value,
        @JsonProperty("currency") String currency
) {}
