package org.apatrios.feign.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@Builder
public record CreateYookassaPaymentDto(
        @JsonProperty("amount") YookassaAmountDto amount,
        @JsonProperty("capture") boolean capture,
        @JsonProperty("confirmation") YookassaConfirmationDto confirmation,
        @JsonProperty("metadata") Map<String, Object> metadata
) {}
