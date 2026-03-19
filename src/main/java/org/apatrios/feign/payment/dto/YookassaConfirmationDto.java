package org.apatrios.feign.payment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record YookassaConfirmationDto(
        @JsonProperty("type") String type,
        @JsonProperty("confirmation_url") String confirmationUrl,
        @JsonProperty("return_url") String returnUrl
) {}
