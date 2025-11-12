package org.apatrios.feign.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class CreateYookassaPaymentDto {

    @JsonProperty("amount")
    YookassaAmountDto amount;

    @JsonProperty("capture")
    boolean capture;

    @JsonProperty("confirmation")
    YookassaConfirmationDto confirmation;
}
