package org.apatrios.feign.telegram.dto;

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
public class TelegramSendRequestDto {
    @JsonProperty("phone_number")
    String phoneNumber;
    @JsonProperty("code")
    String code;
}
