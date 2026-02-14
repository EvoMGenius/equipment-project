package org.apatrios.api.services.support.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO поиска обращений")
public class SearchSupportDto {
    UUID typeId;
    UUID statusId;
    LocalDateTime createDateFrom;
    LocalDateTime createDateTo;
}