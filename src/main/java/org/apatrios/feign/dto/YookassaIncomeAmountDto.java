package org.apatrios.feign.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class YookassaIncomeAmountDto {

    @JsonProperty("value")
    BigDecimal value;

    @JsonProperty("currency")
    String currency;
}
