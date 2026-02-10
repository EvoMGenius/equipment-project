package org.apatrios.feign.call.dto;

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
public class RedSmsRequestDto {
    @JsonProperty("route")
    String route;

    @JsonProperty("to")
    String to;

    @JsonProperty("text")
    String text;
}
