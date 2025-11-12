package org.apatrios.feign.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class YookassaPaymentDto {

    @JsonProperty("id")
    String id;

    @JsonProperty("payment_id")
    String paymentId;

    @JsonProperty("status")
    String status;

    @JsonProperty("amount")
    YookassaAmountDto amount;

    @JsonProperty("income_amount")
    YookassaIncomeAmountDto incomeAmount;

    @JsonProperty("confirmation")
    YookassaConfirmationDto confirmation;

    @JsonProperty("metadata")
    Map<String, Object> metadata;
}