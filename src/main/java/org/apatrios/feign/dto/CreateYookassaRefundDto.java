package org.apatrios.feign.dto;

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
public class CreateYookassaRefundDto {

    @JsonProperty("payment_id")
    String paymentId;

    @JsonProperty("amount")
    YookassaAmountDto amount;

    @JsonProperty("metadata")
    Map<String, Object> metadata;
}
