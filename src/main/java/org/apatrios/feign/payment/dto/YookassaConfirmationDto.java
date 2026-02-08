package org.apatrios.feign.payment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class YookassaConfirmationDto {

    @JsonProperty("type")
    String type;

    @JsonProperty("confirmation_url")
    String confirmationUrl;

    @JsonProperty("return_url")
    String returnUrl;
}
